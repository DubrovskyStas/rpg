package domain;

import lombok.*;

@Data
public class Person {
    private String name;
    private int attack;
    private int theft;
    private int quietAttack;

    public void addExperiense(Bounty bounty) {
        attack+=bounty.getAttackBonus();
        theft+=bounty.getTheftBonus();
        quietAttack+=bounty.getQuitKillBonus();
    }
}
