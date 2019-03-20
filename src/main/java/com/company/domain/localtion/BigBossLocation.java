package com.company.domain.localtion;

import com.company.domain.enemy.BigBoss;
import com.company.domain.enemy.Enemy;
import lombok.Getter;

@Getter
public class BigBossLocation {
    private final Enemy bigBoss = new BigBoss();
    private final String description = "This is last location that you see. Now you can die or win. Good luck!";
}
