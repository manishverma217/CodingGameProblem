package com.codingameproblem.workspace.commands;

import com.codingameproblem.workspace.entities.Level;
import com.codingameproblem.workspace.services.IQuestionService;

import java.util.List;

public class ListQuestionCommand implements ICommand{

    private final IQuestionService questionService;

    public ListQuestionCommand(IQuestionService questionService) {
        this.questionService = questionService;
    }

    // Sample Input Token List:- ["LIST_QUESTION","HIGH"]
    // or
    // ["LIST_QUESTION"]

    @Override
    public void execute(List<String> tokens) {
        Level level;
        try {
            level = Level.valueOf(tokens.get(1));
        } catch(IndexOutOfBoundsException e){
            level = null;
        }
        System.out.println(questionService.getAllQuestionLevelWise(level));
    }

}

