package com.codingameproblem.workspace.commands;

import com.codingameproblem.workspace.services.IUserService;

import java.util.List;

public class AttendContestCommand implements ICommand{

    private final IUserService userService;

    public AttendContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // Sample Input Token List:- ["ATTEND_CONTEST","3","Joey"]
    @Override
    public void execute(List<String> tokens){
        try {
            System.out.println(userService.attendContest(tokens.get(1), tokens.get(2)));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
