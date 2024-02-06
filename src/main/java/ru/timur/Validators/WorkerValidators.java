package ru.timur.Validators;

import ru.timur.Collection.Color;
import ru.timur.Collection.Country;
import ru.timur.Collection.Status;
import ru.timur.Constants;
import ru.timur.Exceptions.FieldInputException;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class WorkerValidators {
    public static Validator idValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                if(Long.parseLong(s) <= 0){
                    throw new FieldInputException("Id must be greater than zero!");
                }
            } catch (NumberFormatException e){
                throw new FieldInputException("Id must be a number!");
            }
        }
    };
    public static Validator nameValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            if(s.isEmpty()){
                throw new FieldInputException("Name can't be empty!");
            }
            if(s.contains(" ")){
                throw new FieldInputException("Name can't contain spaces!");
            }
        }
    };
    public static Validator xValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                if(Double.parseDouble(s) > 657){
                    throw new FieldInputException("x coordinate max value is 657");
                }
            } catch (NumberFormatException e){
                throw new FieldInputException("x coordinate must be a number!");
            }
        }
    };
    public static Validator yValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                Double.parseDouble(s);
            } catch (NumberFormatException e){
                throw new FieldInputException("y coordinate must be a number!");
            }
        }
    };
    public static Validator localDateValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                LocalDateTime.parse(s, Constants.formatter);
            } catch (DateTimeParseException e){
                throw new FieldInputException("Wrong date format!");
            }
        }
    };
    public static Validator zonedlDateValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                ZonedDateTime.parse(s);
            } catch (DateTimeParseException e){
                throw new FieldInputException("Wrong date format!");
            }
        }
    };
    public static Validator salaryValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                if(Integer.parseInt(s) <= 0){
                    throw new FieldInputException("Salary must be greater than zero!");
                }
            } catch (NumberFormatException e){
                throw new FieldInputException("Salary must be a number!");
            }
        }
    };
    public static Validator statusValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                Status.valueOf(s);
            } catch (IllegalArgumentException e){
                throw new FieldInputException("Status not found! Please choose value from list!");
            }
        }
    };
    public static Validator heightValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                if(Long.parseLong(s) <= 0){
                    throw new FieldInputException("Height must be greater than zero!");
                }
            } catch (NumberFormatException e){
                throw new FieldInputException("Height must be a number!");
            }
        }
    };
    public static Validator eyeColorValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                Color.valueOf(s);
            } catch (IllegalArgumentException e){
                throw new FieldInputException("Color not found! Please choose value from list!");
            }
        }
    };
    public static Validator nationalityValidator = new Validator() {
        @Override
        public void validate(String s) throws FieldInputException {
            try{
                Country.valueOf(s);
            } catch (IllegalArgumentException e){
                throw new FieldInputException("Country not found! Please choose value from list!");
            }
        }
    };
}
