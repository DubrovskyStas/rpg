package domain;

import enums.HomeOption;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Constants {
    public static final int SLEEP_TIME_MILLIS = 100;

    public static final String HOME_OUTPUT = String
            .format("This is your home. You can be in safety here. Please select next actions (Type: %s).",
                    concatenatedEnumString(HomeOption.values())
            );

    public static final double DIFFICULT_COEFFICIENT = 0.7;

    @SafeVarargs
    public static <E extends Enum<?>> String concatenatedEnumString(E... e) {
        return String.join(",",
                Arrays.stream(e)
                        .map(Enum::name)
                        .collect(Collectors.toList())
        );
    }

    public static final Scanner INPUT = new Scanner(System.in);
}
