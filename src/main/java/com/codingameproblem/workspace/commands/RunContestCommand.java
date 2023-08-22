package com.codingameproblem.workspace.commands;

import com.codingameproblem.workspace.dtos.ContestSummaryDto;
import com.codingameproblem.workspace.services.IContestService;

import java.util.List;
import java.util.stream.Collectors;

public class RunContestCommand implements ICommand {

    private final IContestService contestService;

    public RunContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public void execute(List<String> tokens) {
        String contestId = tokens.get(1);
        String contestCreator = tokens.get(2);
        try{
            ContestSummaryDto contestSummaryDto = contestService.runContest(contestId, contestCreator);
            System.out.println(contestSummaryDto.getUsers().stream().map(u -> "[UserName:" + u.getName() + " [Questions: " + u.getQuestionsByContest(contestSummaryDto.getContest()) + "]" + "]" ).collect(Collectors.joining(", ")));
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

}

