package ru.timur.Validators;

import ru.timur.Collection.*;
import ru.timur.Constants;
import ru.timur.Exceptions.InvalidDataException;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class WorkerValidators {
    public static Validator workerValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Worker)) throw new InvalidDataException("Wrong type!");
            idValidator.validate(((Worker) value).getId());
            nameValidator.validate(((Worker) value).getName());
            coordinatesValidator.validate(((Worker) value).getCoordinates());
            zonedlDateValidator.validate(((Worker) value).getCreationDate());
            salaryValidator.validate(((Worker) value).getSalary());
            localDateValidator.validate(((Worker) value).getStartDate());
            localDateValidator.validate(((Worker) value).getEndDate());
            statusValidator.validate(((Worker) value).getStatus());
            personValidator.validate(((Worker) value).getPerson());
        }
    };
    public static Validator idValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Long)) throw new InvalidDataException("Wrong type!");
            if((Long) value <= 0) throw new InvalidDataException("Id must be greater than zero!");
        }
    };
    public static Validator nameValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof String)) throw new InvalidDataException("Wrong type!");
            if(((String) value).isEmpty()) throw new InvalidDataException("Name can't be empty!");
            if(((String) value).contains(" ")) throw new InvalidDataException("Name can't contain spaces!");
        }
    };
    public static Validator coordinatesValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Coordinates)) throw new InvalidDataException("Wrong type!");
            xValidator.validate(((Coordinates) value).getX());
            yValidator.validate(((Coordinates) value).getY());
        }
    };
    public static Validator xValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Double)) throw new InvalidDataException("Wrong type!");
            if((Double) value > 657) throw new InvalidDataException("x coordinate max value is 657");
        }
    };
    public static Validator yValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Double)) throw new InvalidDataException("Wrong type!");
        }
    };
    public static Validator localDateValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof LocalDateTime)) throw new InvalidDataException("Wrong type!");
        }
    };
    public static Validator zonedlDateValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof ZonedDateTime)) throw new InvalidDataException("Wrong type!");
        }
    };
    public static Validator salaryValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Integer)) throw new InvalidDataException("Wrong type!");
            if((Integer) value <= 0) throw new InvalidDataException("Salary must be greater than zero!");
        }
    };
    public static Validator statusValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Status)) throw new InvalidDataException("Wrong type!");
        }
    };
    public static Validator personValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Person)) throw new InvalidDataException("Wrong type!");
            heightValidator.validate(((Person) value).getHeight());
            eyeColorValidator.validate(((Person) value).getEyeColor());
            nationalityValidator.validate(((Person) value).getNationality());
        }
    };
    public static Validator heightValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Long)) throw new InvalidDataException("Wrong type!");
            if((Long) value <= 0) throw new InvalidDataException("Height must be greater than zero!");
        }
    };
    public static Validator eyeColorValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Color)) throw new InvalidDataException("Wrong type!");
        }
    };
    public static Validator nationalityValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Country)) throw new InvalidDataException("Wrong type!");
        }
    };
}
