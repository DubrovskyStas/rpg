package service;

import domain.Constants;
import domain.Person;
import enums.YesNo;

import java.util.Optional;
import java.util.function.Supplier;

public class PersonService {

    private final IoService ioService = new IoService();

    private Person initialFighter() {
        Person fighter = new Person();
        fighter.setAttack(10);
        fighter.setTheft(10);
        fighter.setQuietAttack(10);

        return fighter;
    }

    private Person initialRunner() {
        Person runner = new Person();
        runner.setTheft(25);
        runner.setAttack(5);
        runner.setQuietAttack(5);

        return runner;
    }

    private Person initialAssassin() {
        Person assassin = new Person();
        assassin.setQuietAttack(25);
        assassin.setAttack(5);
        assassin.setTheft(5);

        return assassin;
    }


    public Person initPerson() throws InterruptedException {
        System.out.println("Enter your person's name");
        String name = ioService.readLineFromConsole();

        Optional<Person> optionalPerson = Optional.empty();
        while (!optionalPerson.isPresent()) {
            optionalPerson = getInitialPerson("Do you want to become a fighter?", name, this::initialFighter);
            if (!optionalPerson.isPresent()) {
                optionalPerson = getInitialPerson("Do you want to become a thief?", name, this::initialRunner);
                if (!optionalPerson.isPresent()) {
                    optionalPerson = getInitialPerson("Do you want to become an assassin?", name, this::initialAssassin);
                }
            }
            Thread.sleep(Constants.SLEEP_TIME_MILLIS);
        }

        return optionalPerson.get();

    }

    private Optional<Person> getInitialPerson(String question, String name, Supplier<Person> personSupplier) throws InterruptedException {
        System.out.println(question);
        YesNo answer = ioService.selectValue(YesNo.values());
        if (answer == YesNo.YES) {
            Person person = personSupplier.get();
            person.setName(name);
            return Optional.of(person);
        }

        return Optional.empty();
    }
}
