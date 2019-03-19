package service.competition;

import domain.Bounty;
import domain.Person;
import domain.enemy.Enemy;

import java.util.Optional;

public class FightService implements CompetitionService {

    public Optional<Bounty> compete(Person person, Enemy enemy) {
        int personHealth = person.getQuietAttack() + person.getTheft();
        int initialEnemyHealth = enemy.getQuietKillProtection() + enemy.getTheftProtection();
        int enemyHealth = initialEnemyHealth;

        while (personHealth > 0 && enemyHealth > 0) {
            personHealth -= Math.random() * enemy.getAttack();
            enemyHealth -= Math.random() * person.getAttack();
        }

        if (personHealth <= 0) {
            return Optional.empty();
        } else {
            return Optional.of(new Bounty(0,
                    initialEnemyHealth / 2,
                    initialEnemyHealth % 2));
        }
    }
}
