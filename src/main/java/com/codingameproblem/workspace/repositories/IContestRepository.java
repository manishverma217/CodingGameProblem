package com.codingameproblem.workspace.repositories;


import com.codingameproblem.workspace.entities.Contest;
import com.codingameproblem.workspace.entities.Level;

import java.util.List;

public interface IContestRepository extends CRUDRepository<Contest,String> {
    public List<Contest> findAllContestLevelWise(Level level);
}