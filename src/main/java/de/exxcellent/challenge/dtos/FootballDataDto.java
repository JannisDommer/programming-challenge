package de.exxcellent.challenge.dtos;

import com.opencsv.bean.CsvBindByName;

public class FootballDataDto extends Dto{
    @CsvBindByName(column = "Team")
    private String team;
    @CsvBindByName(column = "Goals")
    private int goals;
    @CsvBindByName(column = "Goals allowed")
    private int goalsAllowed;

    public FootballDataDto(){

    }

    public FootballDataDto(String team, int goals, int goalsAllowed) {
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }

    public String getTeam() {
        return team;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public int getGoalDifference() {
        return Math.abs(goals - goalsAllowed);
    }
}
