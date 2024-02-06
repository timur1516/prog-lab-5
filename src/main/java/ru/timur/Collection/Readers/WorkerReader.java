package ru.timur.Collection.Readers;

import ru.timur.Collection.*;
import ru.timur.Validators.WorkerValidators;
import ru.timur.Constants;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.UI.UserIO;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class WorkerReader extends ValueReader {
    private CollectionController collectionController;
    public WorkerReader(UserIO userIO, CollectionController collectionController) {
        super(userIO);
        this.collectionController = collectionController;
    }

    public Worker readWorker() throws FieldInputException {
        long id = this.collectionController.generateId();
        String name = readName();
        Coordinates coordinates = readCoordinates();
        ZonedDateTime creationDate = ZonedDateTime.now();
        Integer salary = readSalary();
        LocalDateTime startDate = readStartDate();
        LocalDateTime endDate = readEndDate();
        Status status = readStatus();
        Person person = readPerson();
        return new Worker(id, name, coordinates, creationDate, salary, startDate, endDate, status, person);
    }

    public long readId() throws FieldInputException {
        return Long.parseLong(readValue("id", WorkerValidators.idValidator));
    }

    public String readName() throws FieldInputException {
        return readValue("name", WorkerValidators.nameValidator);
    }

    public Coordinates readCoordinates() throws FieldInputException {
        return new Coordinates(readX(), readY());
    }

    public double readX() throws FieldInputException {
        return Double.parseDouble(readValue("x coordiate", WorkerValidators.xValidator));
    }

    public double readY() throws FieldInputException {
        return Double.parseDouble(readValue("y coordiate", WorkerValidators.yValidator));
    }

    public ZonedDateTime readCreationDate() throws FieldInputException {
        return ZonedDateTime.parse(readValue("creation date", WorkerValidators.zonedlDateValidator));
    }

    public Integer readSalary() throws FieldInputException {
        return Integer.parseInt(readValue("salary", WorkerValidators.salaryValidator));
    }

    public LocalDateTime readStartDate() throws FieldInputException {
        return LocalDateTime.parse(readValue("start date (" + Constants.DATE_FORMAT_STRING + ")", WorkerValidators.localDateValidator), Constants.formatter);
    }

    public LocalDateTime readEndDate() throws FieldInputException {
        return LocalDateTime.parse(readValue("end date (" + Constants.DATE_FORMAT_STRING + ")", WorkerValidators.localDateValidator), Constants.formatter);
    }

    public Status readStatus() throws FieldInputException {
        userIO.printLn("List of possible status values:");
        for (Status i : Status.values()) {
            userIO.printLn(i);
        }
        return Status.valueOf(readValue("status", WorkerValidators.statusValidator));
    }
    public Person readPerson() throws FieldInputException {
        return new Person(readHeight(), readEyeColor(), readNationality());
    }
    public long readHeight() throws FieldInputException {
        return Long.parseLong(readValue("height", WorkerValidators.heightValidator));
    }
    public Color readEyeColor() throws FieldInputException {
        userIO.printLn("List of possible eye color values:");
        for (Color i : Color.values()) {
            userIO.printLn(i);
        }
        return Color.valueOf(readValue("eye color", WorkerValidators.eyeColorValidator));
    }
    public Country readNationality() throws FieldInputException {
        userIO.printLn("List of possible nationality values:");
        for (Country i : Country.values()) {
            userIO.printLn(i);
        }
        return Country.valueOf(readValue("nationality", WorkerValidators.nationalityValidator));
    }
}