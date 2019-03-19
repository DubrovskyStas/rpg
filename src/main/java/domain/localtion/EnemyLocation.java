package domain.localtion;

import domain.enemy.Enemy;
import enums.EnemyLocationDescription;
import lombok.Data;

@Data
public class EnemyLocation {
    private Enemy enemy;
    private EnemyLocationDescription enemyLocationDescription;

}
