package service.competition;

import domain.Bounty;
import domain.Person;
import domain.enemy.Enemy;

import java.util.Optional;

public interface CompetitionService {

    Optional<Bounty> compete(Person person, Enemy enemy);

    default int calcBountyValue(int value) {
        return Math.toIntExact(Math.round(value* Math.random()));
    }
}
