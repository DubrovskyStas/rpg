package service;

import domain.Person;
import enums.YesNo;
import lombok.RequiredArgsConstructor;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

public class GameService {

    private PersonService personService = new PersonService();
    private LocationService locationService = new LocationService();

    public void loop() throws InterruptedException {
        Person person = personService.initPerson();
        locationService.home(person);
    }
}
