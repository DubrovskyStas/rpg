package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EnemyLocationDescription {
    FORREST("Dark forrest with suspicious whisper"),
    MOUNTAINS("High mountains with some unknown bones"),
    LAKE("This is lake, there is nothing to see because of mist "),
    DESERT("This is really hot place.");

    private final String description;
}
