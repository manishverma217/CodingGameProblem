package com.codingameproblem.workspace.dtos;

import com.codingameproblem.workspace.entities.Contest;
import com.codingameproblem.workspace.entities.User;

import java.util.List;

public class ContestSummaryDto {
    private final Contest contest;
    private final List<User> users;

    public ContestSummaryDto(Contest contest, List<User> userResultList) {
        this.contest = contest;
        this.users = userResultList;
    }

    public Contest getContest() {
        return contest;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "ContestSummaryDto [contest=" + contest + ", users=" + users + "]";
    }

}

