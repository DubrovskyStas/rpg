package com.company.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserAction {
    THEFT("Steal some bounty (theft)"),
    FIGHT("Fight and win in a fair competition (fight)"),
    KILL("Commit a quiet kill (kill)");

    private final String description;
}
