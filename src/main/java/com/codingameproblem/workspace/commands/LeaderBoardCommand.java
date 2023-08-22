package com.codingameproblem.workspace.commands;

import com.codingameproblem.workspace.entities.ScoreOrder;
import com.codingameproblem.workspace.services.IUserService;

import java.util.List;

public class LeaderBoardCommand implements ICommand{

    private final IUserService userService;

    public LeaderBoardCommand(IUserService userService) {
        this.userService = userService;
    }

    // Sample Input Token List:- ["LEADERBOARD","ASC"]
    // or
    // ["LEADERBOARD","DESC"]

    @Override
    public void execute(List<String> tokens) {
        System.out.println(userService.getAllUserScoreOrderWise(ScoreOrder.valueOf(tokens.get(1))));
    }

}

