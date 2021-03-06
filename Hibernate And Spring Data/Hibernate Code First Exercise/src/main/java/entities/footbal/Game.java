package entities.footbal;

import entities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {

    private Team homeTeam;
    private Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private LocalDateTime gameDateTime;
    private double homeTeamWinBetRate;
    private double awayTeamWinBetRate;
    private double drawGameBetRate;
    private Round rounds;
    private Competition competition;

    public Game() {
    }


    @ManyToOne
    @JoinColumn(name = "home_team", referencedColumnName = "id")
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @ManyToOne
    @JoinColumn(name = "away_team", referencedColumnName = "id")
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_team_goals")
    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    @Column(name = "away_team_goals")
    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Column(name = "date_time")
    public LocalDateTime getGameDateTime() {
        return gameDateTime;
    }

    public void setGameDateTime(LocalDateTime gameDateTime) {
        this.gameDateTime = gameDateTime;
    }

    @Column(name = "home_team_win_bet_rate")
    public double getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(double homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    @Column(name = "away_team_win_bet_rate")
    public double getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(double awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    @Column(name = "draw_game_bet_rate")
    public double getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(double drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    @OneToOne
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    public Round getRounds() {
        return rounds;
    }

    public void setRounds(Round rounds) {
        this.rounds = rounds;
    }

    @OneToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
