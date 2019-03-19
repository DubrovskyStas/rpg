package service.competition;


import domain.Bounty;
import domain.Person;
import domain.enemy.Enemy;
import enums.UserAction;

import java.util.Optional;

import static java.lang.Math.round;

public class CompetiotionServiceDispatcher {
    private CompetitionService fightService = new FightService();
    private CompetitionService quietKillService = new QuietKillService();
    private CompetitionService theftService = new TheftService();

    public Optional<Bounty> getBounty(UserAction userAction, Person person, Enemy enemy) {
        switch (userAction) {
            case THEFT:
                return theftService.compete(person, enemy);
            case KILL:
                return quietKillService.compete(person, enemy);
            case FIGHT:
                return fightService.compete(person, enemy);
            default:
                return Optional.empty();
        }
    }
}
