package service.competition;

import domain.Bounty;
import domain.Person;
import domain.enemy.Enemy;

import java.util.Optional;

public class QuietKillService implements CompetitionService {
    @Override
    public Optional<Bounty> compete(Person person, Enemy enemy) {
        boolean isPersonRanAway = Math.random() * person.getQuietAttack() > Math.random() * enemy.getQuietKillProtection();
        if (isPersonRanAway) {
            return Optional.of(new Bounty(
                    calcBountyValue(enemy.getQuietKillProtection()),
                    calcBountyValue(enemy.getQuietKillProtection()),
                    calcBountyValue(enemy.getQuietKillProtection())
            ));
        }
        return Optional.empty();
    }
}
