package com.codingameproblem.workspace.services;

import com.codingameproblem.workspace.entities.Level;
import com.codingameproblem.workspace.entities.Question;
import com.codingameproblem.workspace.repositories.IQuestionRepository;

import java.util.List;

public class QuestionService implements IQuestionService{
    private final IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(String title, Level level, Integer difficultyScore) {
        final Question question = new Question(title,level, difficultyScore);
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestionLevelWise(Level level) {
        if(level != null){
            return questionRepository.findAllQuestionLevelWise(level);
        }
        return questionRepository.findAll();
    }
}

