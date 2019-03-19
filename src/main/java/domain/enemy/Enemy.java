package domain.enemy;

import enums.EnemyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enemy {
    private EnemyDescription enemyDescription;
    protected int attack;
    protected int theftProtection;
    protected int quietKillProtection;
}
