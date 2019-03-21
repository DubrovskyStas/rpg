package com.company.service;

import com.company.domain.Person;
import com.company.enums.YesNo;

import java.io.IOException;

public class GameService {
    private PersonService personService = new PersonService();
    private LocationService locationService = new LocationService();
    private IoService ioService = new IoService();

    public void loop() throws InterruptedException, IOException, ClassNotFoundException {
        Person person = getPerson();
        locationService.home(person);
    }

    private Person getPerson() throws InterruptedException, IOException, ClassNotFoundException {
        if (personService.isBackupExists()) {
            System.out.println("Do you want to restore backup?");
            YesNo answer = ioService.selectValue(YesNo.values());
            switch (answer) {
                case YES:
                    return personService.restoreFromBackup();
                case NO:
                    return personService.initPerson();
            }
        }
        return personService.initPerson();
    }


}
