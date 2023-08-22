package com.codingameproblem.workspace.services;

import com.codingameproblem.workspace.dtos.UserRegistrationDto;
import com.codingameproblem.workspace.entities.*;
import com.codingameproblem.workspace.exceptions.ContestNotFoundException;
import com.codingameproblem.workspace.exceptions.InvalidOperationException;
import com.codingameproblem.workspace.exceptions.UserNotFoundException;
import com.codingameproblem.workspace.repositories.IContestRepository;
import com.codingameproblem.workspace.repositories.IUserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IContestRepository contestRepository;

    public UserService(IUserRepository userRepository, IContestRepository contestRepository) {
        this.userRepository = userRepository;
        this.contestRepository = contestRepository;
    }

    @Override
    public User create(String name) {
        Integer id = userRepository.findAll().size() + 1;
        User user = new User(id.toString(), name, 0);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUserScoreOrderWise(ScoreOrder scoreOrder){
        List<User> list = userRepository.findAll();
        switch(scoreOrder) {
            case ASC :
                return list.stream()
                        .sorted(Comparator.comparing(User::getScore))
                        .collect(Collectors.toList());

            case DESC :
                return list.stream()
                        .sorted(Comparator.comparing(User::getScore).reversed())
                        .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public UserRegistrationDto attendContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException {
        Contest contest = contestRepository.findById(contestId).orElseThrow(() -> new ContestNotFoundException("Cannot Attend Contest. Contest for given id:"+contestId+" not found!"));
        User user = userRepository.findByName(userName).orElseThrow(() -> new UserNotFoundException("Cannot Attend Contest. User for given name:"+ userName+" not found!"));
        if(contest.getContestStatus().equals(ContestStatus.IN_PROGRESS)){
            throw new InvalidOperationException("Cannot Attend Contest. Contest for given id:"+contestId+" is in progress!");
        }
        if(contest.getContestStatus().equals(ContestStatus.ENDED)){
            throw new InvalidOperationException("Cannot Attend Contest. Contest for given id:"+contestId+" is ended!");
        }
        if(user.checkIfContestExists(contest)){
            throw new InvalidOperationException("Cannot Attend Contest. Contest for given id:"+contestId+" is already registered!");
        }
        user.addContest(contest);
        userRepository.save(user);
        return new UserRegistrationDto(contest.getName(), user.getName(), RegisterationStatus.REGISTERED);
    }

    @Override
    public UserRegistrationDto withdrawContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException {
        Contest contest = contestRepository.findById(contestId).orElseThrow(() -> new ContestNotFoundException("Cannot Withdraw Contest. Contest for given id:"+contestId+" not found!"));
        User user = userRepository.findByName(userName).orElseThrow(() -> new UserNotFoundException("Cannot Withdraw Contest. User for given name:"+ userName+" not found!"));
        if(contest.getContestStatus().equals(ContestStatus.IN_PROGRESS)){
            throw new InvalidOperationException("Cannot Withdraw Contest. Contest for given id:"+contestId+" is in progress!");
        }
        if(contest.getContestStatus().equals(ContestStatus.ENDED)){
            throw new InvalidOperationException("Cannot Withdraw Contest. Contest for given id:"+contestId+" is ended!");
        }
        if(!user.checkIfContestExists(contest)){
            throw new InvalidOperationException("Cannot Withdraw Contest. Contest for given id:"+contestId+" is already registered!");
        }
        user.deleteContest(contest);
        userRepository.save(user);
        return new UserRegistrationDto(contest.getName(), user.getName(), RegisterationStatus.NOT_REGISTERED);
    }
}

