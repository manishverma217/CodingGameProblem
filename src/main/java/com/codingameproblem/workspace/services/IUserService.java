package com.codingameproblem.workspace.services;

import com.codingameproblem.workspace.dtos.UserRegistrationDto;
import com.codingameproblem.workspace.entities.ScoreOrder;
import com.codingameproblem.workspace.entities.User;
import com.codingameproblem.workspace.exceptions.ContestNotFoundException;
import com.codingameproblem.workspace.exceptions.InvalidOperationException;
import com.codingameproblem.workspace.exceptions.UserNotFoundException;

import java.util.List;

public interface IUserService {
    public User create(String name);
    public List<User> getAllUserScoreOrderWise(ScoreOrder scoreOrder);
    public UserRegistrationDto attendContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException;
    public UserRegistrationDto withdrawContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException;
}
