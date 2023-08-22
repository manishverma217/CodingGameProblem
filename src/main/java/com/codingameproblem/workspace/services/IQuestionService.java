package com.codingameproblem.workspace.services;

import com.codingameproblem.workspace.entities.Level;
import com.codingameproblem.workspace.entities.Question;

import java.util.List;

public interface IQuestionService {
    public Question create(String title, Level level, Integer difficultyScore);
    public List<Question> getAllQuestionLevelWise(Level level);
}
