package service.competition;

import domain.Bounty;
import domain.Person;
import domain.enemy.Enemy;

import java.util.Optional;

public class TheftService implements CompetitionService {
    @Override
    public Optional<Bounty> compete(Person person, Enemy enemy) {
        boolean isPersonRanAway = Math.random() * person.getTheft() > Math.random() * enemy.getTheftProtection();
        if (isPersonRanAway) {
            return Optional.of(new Bounty(
                    calcBountyValue(enemy.getTheftProtection()),
                    calcBountyValue(enemy.getTheftProtection()),
                    calcBountyValue(enemy.getTheftProtection())
            ));
        }
        return Optional.empty();
    }


}
