package com.codingameproblem.workspace.commands;

import com.codingameproblem.workspace.services.IUserService;

import java.util.List;

public class CreateUserCommand implements ICommand{

    private final IUserService userService;

    public CreateUserCommand(IUserService userService) {
        this.userService = userService;
    }

    // Sample Input Token List:- ["CREATE_QUESTION","Ross"]

    @Override
    public void execute(List<String> tokens) {
        System.out.println(userService.create(tokens.get(1)));
    }

}

