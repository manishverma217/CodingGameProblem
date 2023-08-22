package com.codingameproblem.workspace.repositories;

import com.codingameproblem.workspace.entities.Level;
import com.codingameproblem.workspace.entities.Question;

import java.util.List;

public interface IQuestionRepository extends CRUDRepository<Question,String> {
    public List<Question> findAllQuestionLevelWise(Level level);
}

