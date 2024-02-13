package ru.timur.Validators;

import ru.timur.Collection.*;
import ru.timur.Exceptions.InvalidDataException;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class WorkerValidators {
    public static Validator workerValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(!(value instanceof Worker)) throw new RuntimeException("Wrong argument type!");
            idValidator.validate(((Worker) value).getId());
            nameValidator.validate(((Worker) value).getName());
            coordinatesValidator.validate(((Worker) value).getCoordinates());
            creationDateValidator.validate(((Worker) value).getCreationDate());
            salaryValidator.validate(((Worker) value).getSalary());
            startDateValidator.validate(((Worker) value).getStartDate());
            endDateValidator.validate(((Worker) value).getEndDate());
            statusValidator.validate(((Worker) value).getStatus());
            personValidator.validate(((Worker) value).getPerson());
        }
    };
    public static Validator idValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Id can't be empty!");
            if(!(value instanceof Long)) throw new RuntimeException("Wrong argument type!");
            if((Long) value <= 0) throw new InvalidDataException("Id must be greater than zero!");
        }
    };
    public static Validator nameValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Name can't be empty!");
            if(!(value instanceof String)) throw new RuntimeException("Wrong argument type!");
            if(((String) value).isEmpty()) throw new InvalidDataException("Name can't be empty!");
            if(((String) value).contains(" ")) throw new InvalidDataException("Name can't contain spaces!");
        }
    };
    public static Validator coordinatesValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Coordinates can't be empty!");
            if(!(value instanceof Coordinates)) throw new RuntimeException("Wrong argument type!");
            xValidator.validate(((Coordinates) value).getX());
            yValidator.validate(((Coordinates) value).getY());
        }
    };
    public static Validator xValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("X can't be empty!");
            if(!(value instanceof Double)) throw new RuntimeException("Wrong argument type!");
            if((Double) value > 657) throw new InvalidDataException("x coordinate max value is 657");
        }
    };
    public static Validator yValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Y can't be empty!");
            if(!(value instanceof Double)) throw new RuntimeException("Wrong argument type!");
        }
    };
    public static Validator startDateValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Start date can't be empty!");
            if(!(value instanceof LocalDateTime)) throw new RuntimeException("Wrong argument type!");
        }
    };
    public static Validator endDateValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) return;
            if(!(value instanceof LocalDateTime)) throw new RuntimeException("Wrong argument type!");
        }
    };
    public static Validator creationDateValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Creation date can't be empty!");
            if(!(value instanceof ZonedDateTime)) throw new RuntimeException("Wrong argument type!");
        }
    };
    public static Validator salaryValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Salary can't be empty!");
            if(!(value instanceof Integer)) throw new RuntimeException("Wrong argument type!");
            if((Integer) value <= 0) throw new InvalidDataException("Salary must be greater than zero!");
        }
    };
    public static Validator statusValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Status can't be empty!");
            if(!(value instanceof Status)) throw new RuntimeException("Wrong argument type!");
        }
    };
    public static Validator personValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) return;
            if(!(value instanceof Person)) throw new RuntimeException("Wrong argument type!");
            heightValidator.validate(((Person) value).getHeight());
            eyeColorValidator.validate(((Person) value).getEyeColor());
            nationalityValidator.validate(((Person) value).getNationality());
        }
    };
    public static Validator heightValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Height can't be empty!");
            if(!(value instanceof Long)) throw new RuntimeException("Wrong argument type!");
            if((Long) value <= 0) throw new InvalidDataException("Height must be greater than zero!");
        }
    };
    public static Validator eyeColorValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) return;
            if(!(value instanceof Color)) throw new RuntimeException("Wrong argument type!");
        }
    };
    public static Validator nationalityValidator = new Validator() {
        @Override
        public void validate(Object value) throws InvalidDataException {
            if(value == null) return;
            if(!(value instanceof Country)) throw new RuntimeException("Wrong argument type!");
        }
    };
}
