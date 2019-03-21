package com.company.service;

import com.company.Constants;
import com.company.domain.Bounty;
import com.company.domain.Person;
import com.company.domain.enemy.Enemy;
import com.company.domain.localtion.BigBossLocation;
import com.company.domain.localtion.EnemyLocation;
import com.company.enums.EnemyDescription;
import com.company.enums.EnemyLocationDescription;
import com.company.enums.HomeOption;
import com.company.enums.UserAction;
import com.company.service.competition.CompetitionServiceDispatcher;

import java.io.IOException;
import java.util.Optional;

import static java.lang.Math.*;

public class LocationService {
    private IoService ioService = new IoService();
    private PersonService personService = new PersonService();
    private CompetitionServiceDispatcher competitionServiceDispatcher = new CompetitionServiceDispatcher();

    public void home(Person person) throws InterruptedException, IOException {
        while (true) {
            System.out.println(Constants.HOME_OUTPUT);
            System.out.println(person);

            HomeOption homeOption = ioService.selectValue(HomeOption.values());
            switch (homeOption) {
                case ENEMY:
                    enemyLocation(person);
                    break;
                case BOSS:
                    bigBossLocation(person);
                    break;
                case SAVE:
                    personService.createBackup(person);
                    break;
                case EXIT:
                    System.out.println("Good bye! See you later!");
                    System.exit(0);
            }
        }
    }

    private void bigBossLocation(Person person) throws InterruptedException {
        BigBossLocation bigBossLocation = new BigBossLocation();
        System.out.println(bigBossLocation.getDescription());
        System.out.println(bigBossLocation.getBigBoss());
        System.out.println();
        for (UserAction userAction : UserAction.values()) {
            System.out.println(userAction.getDescription());
        }

        UserAction userAction = ioService.selectValue(UserAction.values());

        Optional<Bounty> bountyOptional = competitionServiceDispatcher.getBounty(userAction,
                person,
                bigBossLocation.getBigBoss());
        if (bountyOptional.isPresent()) {
            System.out.println("You won and will successfully finish game! Congratulations!");
            System.exit(0);
        } else {
            System.out.println("Unfortunately you couldn't defeat the Big Boss. Don't worry and try it again next time.");
            System.out.println();
        }

    }

    private void enemyLocation(Person person) throws InterruptedException {
        EnemyLocation enemyLocation = generateLocation(person);
        System.out.printf("Now you are in the %s%n", enemyLocation.getEnemyLocationDescription().name());
        System.out.println(enemyLocation.getEnemyLocationDescription().getDescription());
        System.out.printf("Now you are seeing a %s%n", enemyLocation.getEnemy().getEnemyDescription().name());
        System.out.println(enemyLocation.getEnemy().getEnemyDescription().getDescription());
        System.out.println(enemyLocation.getEnemy());
        System.out.println();
        for (UserAction userAction: UserAction.values()) {
            System.out.println(userAction.getDescription());
        }

        UserAction userAction = ioService.selectValue(UserAction.values());

        Optional<Bounty> bountyOptional = competitionServiceDispatcher.getBounty(userAction,
                person,
                enemyLocation.getEnemy());

        if (bountyOptional.isPresent()) {
            System.out.println("You won and got some bounty. Congratulations!");
            person.addExperience(bountyOptional.get());
        } else {
            System.out.println("Unfortunately you couldn't defeat the enemy. Next time you can to win.");
        }
    }

    private EnemyLocation generateLocation(Person person) {
        EnemyLocation enemyLocation = new EnemyLocation();
        enemyLocation.setEnemy(generateEnemy(person));
        enemyLocation.setEnemyLocationDescription(generateDescription(EnemyLocationDescription.values()));

        return enemyLocation;
    }

    private Enemy generateEnemy(Person person) {
        Enemy enemy = new Enemy();
        enemy.setAttack(generateProperty(person.getAttack()));
        enemy.setTheftProtection(generateProperty(person.getTheft()));
        enemy.setQuietKillProtection(generateProperty(person.getQuietAttack()));
        enemy.setEnemyDescription(generateDescription(EnemyDescription.values()));

        return enemy;
    }

    private int generateProperty(int value) {
        return toIntExact(round(value * Constants.DIFFICULT_COEFFICIENT * random()));
    }

    @SafeVarargs
    private final <E extends Enum<?>> E generateDescription(E... values) {
        int ordinal = toIntExact(round(random() * values.length));
        for (E e : values) {
            if (ordinal == e.ordinal()) {
                return e;
            }
        }

        return values[0];
    }
}
