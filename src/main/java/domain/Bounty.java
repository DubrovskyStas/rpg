package domain;

import lombok.Data;

@Data
public class Bounty {
    private final int attackBonus;
    private final int theftBonus;
    private final int quitKillBonus;
}
