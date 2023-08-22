package com.codingameproblem.workspace.commands;

import com.codingameproblem.workspace.entities.Level;
import com.codingameproblem.workspace.entities.Question;
import com.codingameproblem.workspace.services.IQuestionService;

import java.util.List;

public class CreateQuestionCommand implements ICommand{

    private final IQuestionService questionService;

    public CreateQuestionCommand(IQuestionService questionService) {
        this.questionService = questionService;
    }

    // Sample Input Token List:- ["CREATE_QUESTION","Question22","HIGH","220"]

    @Override
    public void execute(List<String> tokens) {
        String title = tokens.get(1);
        String level = tokens.get(2);
        Integer score = Integer.parseInt(tokens.get(3));
        Question question = questionService.create(title, Level.valueOf(level),score);
        System.out.println(question);
    }
}

