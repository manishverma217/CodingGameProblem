package com.codingameproblem.workspace.commands;

import com.codingameproblem.workspace.entities.Level;
import com.codingameproblem.workspace.services.IContestService;

import java.util.List;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // Sample Input Token List:- ["CREATE_CONTEST","CRIODO2_CONTEST","LOW Monica","40"]
    // or
    // ["CREATE_CONTEST","CRIODO1_CONTEST","HIGH","Ross"]

    @Override
    public void execute(List<String> tokens) {
        Integer numQuestions;
        try {
            numQuestions = Integer.valueOf(tokens.get(4));
        } catch(IndexOutOfBoundsException e) {
            numQuestions = null;
        }
        try{
            System.out.println(contestService.create(tokens.get(1), Level.valueOf(tokens.get(2)), tokens.get(3), numQuestions));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
