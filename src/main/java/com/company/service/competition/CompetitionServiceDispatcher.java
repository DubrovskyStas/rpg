package com.company.service.competition;


import com.company.domain.Bounty;
import com.company.domain.Person;
import com.company.domain.enemy.Enemy;
import com.company.enums.UserAction;

import java.util.Optional;

public class CompetitionServiceDispatcher {
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
