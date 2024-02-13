package ru.timur.Collection.Readers;

import ru.timur.Collection.*;
import ru.timur.Parsers.WorkerParsers;
import ru.timur.Validators.WorkerValidators;
import ru.timur.Constants;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.UI.Console;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class WorkerReader extends ValueReader {
    private CollectionController collectionController;
    public WorkerReader(CollectionController collectionController) {
        this.collectionController = collectionController;
    }

    public Worker readWorker() throws InvalidDataException {
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

    public long readId() throws InvalidDataException {
        return (long) readValue("id", WorkerValidators.idValidator, WorkerParsers.longParser);
    }

    public String readName() throws InvalidDataException {
        return (String) readValue("name", WorkerValidators.nameValidator, WorkerParsers.stringParser);
    }

    public Coordinates readCoordinates() throws InvalidDataException {
        return new Coordinates(readX(), readY());
    }

    public double readX() throws InvalidDataException {
        return (double) readValue("x coordiate", WorkerValidators.xValidator, WorkerParsers.doubleParser);
    }

    public double readY() throws InvalidDataException {
        return (double) readValue("y coordiate", WorkerValidators.yValidator, WorkerParsers.doubleParser);
    }

    public ZonedDateTime readCreationDate() throws InvalidDataException {
        return (ZonedDateTime) readValue("creation date", WorkerValidators.creationDateValidator, WorkerParsers.zonedlDateTimeParser);
    }

    public Integer readSalary() throws InvalidDataException {
        return (Integer) readValue("salary", WorkerValidators.salaryValidator, WorkerParsers.integerParser);
    }

    public LocalDateTime readStartDate() throws InvalidDataException {
        return (LocalDateTime) readValue("start date (" + Constants.DATE_FORMAT_STRING + ")", WorkerValidators.startDateValidator, WorkerParsers.localDateTimeParser);
    }

    public LocalDateTime readEndDate() throws InvalidDataException {
        return (LocalDateTime) readValue("end date (" + Constants.DATE_FORMAT_STRING + ")", WorkerValidators.endDateValidator, WorkerParsers.localDateTimeParser);
    }

    public Status readStatus() throws InvalidDataException {
        if(!Constants.SCRIPT_MODE) {
            Console.getInstance().printLn("List of possible status values:");
            for (Status i : Status.values()) {
                Console.getInstance().printLn(i);
            }
        }
        return (Status) readValue("status", WorkerValidators.statusValidator, WorkerParsers.statusParser);
    }
    public Person readPerson() throws InvalidDataException {
        return new Person(readHeight(), readEyeColor(), readNationality());
    }
    public long readHeight() throws InvalidDataException {
        return (long) readValue("height", WorkerValidators.heightValidator, WorkerParsers.longParser);
    }
    public Color readEyeColor() throws InvalidDataException {
        if(!Constants.SCRIPT_MODE) {
            Console.getInstance().printLn("List of possible eye color values:");
            for (Color i : Color.values()) {
                Console.getInstance().printLn(i);
            }
        }
        return (Color) readValue("eye color", WorkerValidators.eyeColorValidator, WorkerParsers.eyeColorParser);
    }
    public Country readNationality() throws InvalidDataException {
        if(!Constants.SCRIPT_MODE) {
            Console.getInstance().printLn("List of possible nationality values:");
            for (Country i : Country.values()) {
                Console.getInstance().printLn(i);
            }
        }
        return (Country) readValue("nationality", WorkerValidators.nationalityValidator, WorkerParsers.nationalityParser);
    }
}