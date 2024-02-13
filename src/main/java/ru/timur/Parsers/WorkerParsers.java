package ru.timur.Parsers;

import ru.timur.Collection.Color;
import ru.timur.Collection.Country;
import ru.timur.Collection.Status;
import ru.timur.Constants;
import ru.timur.Exceptions.InvalidDataException;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class WorkerParsers {
    public static Parser stringParser = new Parser() {
        @Override
        public Object parse(String s) throws InvalidDataException {
            return s;
        }
    };
    public static Parser longParser = new Parser() {
        @Override
        public Object parse(String s) throws InvalidDataException {
            try{
                return Long.parseLong(s);
            } catch (NumberFormatException e){
                throw new InvalidDataException("Value must be a long!");
            }
        }
    };
    public static Parser integerParser = new Parser() {
        @Override
        public Object parse(String s) throws InvalidDataException {
            try{
                return Integer.parseInt(s);
            } catch (NumberFormatException e){
                throw new InvalidDataException("Value must be an integer!");
            }
        }
    };
    public static Parser doubleParser = new Parser() {
        @Override
        public Object parse(String s) throws InvalidDataException {
            try{
                return Double.parseDouble(s);
            } catch (NumberFormatException e){
                throw new InvalidDataException("Value must be a double!");
            }
        }
    };
    public static Parser localDateTimeParser = new Parser() {
        @Override
        public Object parse(String s) throws InvalidDataException {
            try{
                return LocalDateTime.parse(s, Constants.formatter);
            } catch (DateTimeParseException e){
                throw new InvalidDataException("Wrong date format!");
            }
        }
    };
    public static Parser zonedlDateTimeParser = new Parser() {
        @Override
        public Object parse(String s) throws InvalidDataException {
            try{
                return ZonedDateTime.parse(s);
            } catch (DateTimeParseException e){
                throw new InvalidDataException("Wrong date format!");
            }
        }
    };
    public static Parser statusParser = new Parser() {
        @Override
        public Object parse(String s) throws InvalidDataException {
            try{
                return Status.valueOf(s);
            } catch (IllegalArgumentException e){
                throw new InvalidDataException("Status not found! Please choose value from list!");
            }
        }
    };
    public static Parser eyeColorParser = new Parser() {
        @Override
        public Object parse(String s) throws InvalidDataException {
            try{
                return Color.valueOf(s);
            } catch (IllegalArgumentException e){
                throw new InvalidDataException("Color not found! Please choose value from list!");
            }
        }
    };
    public static Parser nationalityParser = new Parser() {
        @Override
        public Object parse(String s) throws InvalidDataException {
            try{
                return Country.valueOf(s);
            } catch (IllegalArgumentException e){
                throw new InvalidDataException("Country not found! Please choose value from list!");
            }
        }
    };
}
