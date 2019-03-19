package domain.localtion;

import domain.enemy.BigBoss;
import domain.enemy.Enemy;
import lombok.Data;
import lombok.Getter;

@Getter
public class BigBossLocation {
    private final Enemy bigBoss = new BigBoss();
    private final String description = "This is last location that you see. Now you can die or win. Good luck!";
}
