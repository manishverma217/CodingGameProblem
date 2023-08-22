package com.codingameproblem.workspace.services;

import com.codingameproblem.workspace.dtos.ContestSummaryDto;
import com.codingameproblem.workspace.entities.Contest;
import com.codingameproblem.workspace.entities.Level;
import com.codingameproblem.workspace.exceptions.ContestNotFoundException;
import com.codingameproblem.workspace.exceptions.InvalidContestException;
import com.codingameproblem.workspace.exceptions.QuestionNotFoundException;
import com.codingameproblem.workspace.exceptions.UserNotFoundException;

import java.util.List;

public interface IContestService {
    public Contest create(String contestName, Level level, String contestCreator, Integer numQuestion) throws UserNotFoundException, QuestionNotFoundException;
    public List<Contest> getAllContestLevelWise(Level level);
    public ContestSummaryDto runContest(String contestId, String contestCreator) throws ContestNotFoundException, InvalidContestException;
}
