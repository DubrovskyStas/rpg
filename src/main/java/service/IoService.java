package service;

import domain.Constants;

import java.util.Optional;
import java.util.Scanner;

import static domain.Constants.INPUT;
import static domain.Constants.SLEEP_TIME_MILLIS;

public class IoService {
    public String readLineFromConsole() throws InterruptedException {
        String s = "";
            while (s.isEmpty()) {
                s = INPUT.nextLine();
                Thread.sleep(SLEEP_TIME_MILLIS);
            }
        return s;
    }

    @SafeVarargs
    public final <E extends Enum<?>> E selectValue(E... values) throws InterruptedException {
        while (true) {
            String s = INPUT.nextLine();
            for (E e : values) {
                if (s.equalsIgnoreCase(e.name())) {
                    return e;
                }
            }
            System.out.println(String.format("Please enter only: (%s)", Constants.concatenatedEnumString(values)));
            Thread.sleep(SLEEP_TIME_MILLIS);
        }
    }
}
