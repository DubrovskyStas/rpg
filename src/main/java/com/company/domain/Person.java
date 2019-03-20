package com.company.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Person implements Serializable {

    private static final long serialVersionUID = 42L;

    private String name;
    private int attack;
    private int theft;
    private int quietAttack;

    public void addExperience(Bounty bounty) {
        attack+=bounty.getAttackBonus();
        theft+=bounty.getTheftBonus();
        quietAttack+=bounty.getQuitKillBonus();
    }
}
