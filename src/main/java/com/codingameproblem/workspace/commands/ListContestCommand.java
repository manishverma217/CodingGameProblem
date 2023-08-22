package com.codingameproblem.workspace.commands;

import com.codingameproblem.workspace.entities.Level;
import com.codingameproblem.workspace.services.IContestService;

import java.util.List;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;

    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // Sample Input Token List:- ["LIST_CONTEST","HIGH"]
    // or
    // ["LIST_CONTEST"]

    @Override
    public void execute(List<String> tokens) {
        Level level;
        try {
            level = Level.valueOf(tokens.get(1));
        } catch (IndexOutOfBoundsException e){
            level = null;
        }
        System.out.println(contestService.getAllContestLevelWise(level));
    }
}
