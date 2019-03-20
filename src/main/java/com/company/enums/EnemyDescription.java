package com.company.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EnemyDescription {
    ORC("Hungry orc, who haven't eaten a far ago"),
    VAMPIRE("Pallid vampire with red eyes and sharp teeth"),
    BANDIT("Big stinky bandit");

    private final String description;

}
