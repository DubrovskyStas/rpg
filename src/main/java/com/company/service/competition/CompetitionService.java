package com.company.service.competition;

import com.company.domain.Bounty;
import com.company.domain.Person;
import com.company.domain.enemy.Enemy;

import java.util.Optional;

public interface CompetitionService {

    Optional<Bounty> compete(Person person, Enemy enemy);

    default int calcBountyValue(int value) {
        return (int) Math.round(value * Math.random());
    }
}
