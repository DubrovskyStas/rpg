package com.company.service;

import com.company.Constants;

import static com.company.Constants.INPUT;
import static com.company.Constants.SLEEP_TIME_MILLIS;

public class IoService {

    @SafeVarargs
    public final <E extends Enum<?>> E selectValue(E... values) throws InterruptedException {
        System.out.printf("Please enter only: (%s)%n", Constants.concatenatedEnumString(values));
        while (true) {
            String s = INPUT.nextLine();
            for (E e : values) {
                if (s.equalsIgnoreCase(e.name())) {
                    return e;
                }
            }
            System.out.printf("Please enter only: (%s)%n", Constants.concatenatedEnumString(values));
            Thread.sleep(SLEEP_TIME_MILLIS);
        }
    }

    public String getBackupPath() {
        return System.getProperty("backup.path", System.getProperty("user.home"));
    }
}
