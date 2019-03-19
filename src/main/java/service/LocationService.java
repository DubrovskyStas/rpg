package service;

import domain.Bounty;
import domain.Constants;
import domain.Person;
import domain.enemy.Enemy;
import domain.localtion.EnemyLocation;
import enums.EnemyDescription;
import enums.EnemyLocationDescription;
import enums.HomeOption;
import enums.UserAction;
import service.competition.CompetiotionServiceDispatcher;

import java.util.Optional;

import static java.lang.Math.*;

public class LocationService {
    private IoService ioService = new IoService();
    private CompetiotionServiceDispatcher competiotionServiceDispatcher = new CompetiotionServiceDispatcher();

    public void home(Person person) throws InterruptedException {
        HomeOption homeOption = HomeOption.ENEMY;
        while (homeOption == HomeOption.ENEMY) {
            System.out.println(Constants.HOME_OUTPUT);
            System.out.println(person);
            homeOption = ioService.selectValue(HomeOption.values());
            if (homeOption == HomeOption.ENEMY) {
                enemyLocation(person);
            }
        }

    }

    private void enemyLocation(Person person) throws InterruptedException {
        EnemyLocation enemyLocation = generateLocation(person);
        System.out.println("Now you are in the " + enemyLocation.getEnemyLocationDescription().name());
        System.out.println(enemyLocation.getEnemyLocationDescription().getDescription());
        System.out.println("You can see " + enemyLocation.getEnemy().getEnemyDescription().name());
        System.out.println(enemyLocation.getEnemy().getEnemyDescription().getDescription());
        for (UserAction userAction: UserAction.values()) {
            System.out.println(userAction.getDescription());
        }

        UserAction userAction = ioService.selectValue(UserAction.values());

        Optional<Bounty> bountyOptional = competiotionServiceDispatcher.getBounty(userAction, person, enemyLocation.getEnemy());
        bountyOptional.ifPresent(person::addExperiense);
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
