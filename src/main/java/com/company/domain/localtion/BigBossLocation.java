package com.company.domain.localtion;

import com.company.domain.enemy.BigBoss;
import com.company.domain.enemy.Enemy;
import lombok.Getter;

@Getter
public class BigBossLocation {
    private final Enemy bigBoss = new BigBoss();
    private final String description = "If you win Big Boss you will finish game! Good luck!";
}
