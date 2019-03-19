package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserAction {
    THEFT("1. Steal some bounty (theft)"),
    FIGHT("2. Fight and win in a fair competition (fight)"),
    KILL("3. Commit a quiet kill (kill)");

    private final String description;
}
