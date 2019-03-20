package com.company.domain.localtion;

import com.company.domain.enemy.Enemy;
import com.company.enums.EnemyLocationDescription;
import lombok.Data;

@Data
public class EnemyLocation {
    private Enemy enemy;
    private EnemyLocationDescription enemyLocationDescription;

}
