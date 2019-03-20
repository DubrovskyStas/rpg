package com.company.service;

import com.company.Constants;
import com.company.domain.Person;
import com.company.enums.YesNo;

import java.io.*;
import java.util.Optional;
import java.util.function.Supplier;

import static com.company.Constants.INPUT;

public class PersonService {
    private final IoService ioService = new IoService();

    private Person initialFighter() {
        return new Person()
                .setAttack(10)
                .setQuietAttack(10)
                .setTheft(10);
    }

    private Person initThief() {
        return new Person()
                .setAttack(5)
                .setTheft(20)
                .setQuietAttack(5);
    }

    private Person initialAssassin() {
        return new Person()
                .setAttack(5)
                .setTheft(5)
                .setQuietAttack(20);
    }

    public Person initPerson() throws InterruptedException {
        System.out.println("Enter your person's name");
        String name = INPUT.nextLine();

        Optional<Person> optionalPerson = Optional.empty();
        while (!optionalPerson.isPresent()) {
            optionalPerson = getInitialPerson("Do you want to become a fighter?", name, this::initialFighter);
            if (!optionalPerson.isPresent()) {
                optionalPerson = getInitialPerson("Do you want to become a thief?", name, this::initThief);
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

    public void createBackup(Person person) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(getBackupName()))) {
            outputStream.writeObject(person);
        }
    }

    public Person restoreFromBackup() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(getBackupName()))) {
            return (Person) inputStream.readObject();
        }
    }

    public boolean isBackupExists() {
        return new File(getBackupName()).exists();
    }

    private String getBackupName() {
        return ioService.getBackupPath() +
                File.separator +
                "rpg.bkp";
    }
}
