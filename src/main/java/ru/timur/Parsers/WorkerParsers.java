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
    public static Parser<String> stringParser = new Parser<String>() {
        @Override
        public String parse(String s) throws InvalidDataException {
            return s;
        }
    };
    public static Parser<Long> longParser = new Parser<Long>() {
        @Override
        public Long parse(String s) throws InvalidDataException {
            try{
                return Long.parseLong(s);
            } catch (NumberFormatException e){
                throw new InvalidDataException("Value must be a long!");
            }
        }
    };
    public static Parser<Integer> integerParser = new Parser<Integer>() {
        @Override
        public Integer parse(String s) throws InvalidDataException {
            try{
                return Integer.parseInt(s);
            } catch (NumberFormatException e){
                throw new InvalidDataException("Value must be an integer!");
            }
        }
    };
    public static Parser<Double> doubleParser = new Parser<Double>() {
        @Override
        public Double parse(String s) throws InvalidDataException {
            try{
                return Double.parseDouble(s);
            } catch (NumberFormatException e){
                throw new InvalidDataException("Value must be a double!");
            }
        }
    };
    public static Parser<LocalDateTime> localDateTimeParser = new Parser<LocalDateTime>() {
        @Override
        public LocalDateTime parse(String s) throws InvalidDataException {
            try{
                return LocalDateTime.parse(s, Constants.formatter);
            } catch (DateTimeParseException e){
                throw new InvalidDataException("Wrong date format!");
            }
        }
    };
    public static Parser<ZonedDateTime> zonedlDateTimeParser = new Parser<ZonedDateTime>() {
        @Override
        public ZonedDateTime parse(String s) throws InvalidDataException {
            try{
                return ZonedDateTime.parse(s);
            } catch (DateTimeParseException e){
                throw new InvalidDataException("Wrong date format!");
            }
        }
    };
    public static Parser<Status> statusParser = new Parser<Status>() {
        @Override
        public Status parse(String s) throws InvalidDataException {
            try{
                return Status.valueOf(s);
            } catch (IllegalArgumentException e){
                throw new InvalidDataException("Status not found! Please choose value from list!");
            }
        }
    };
    public static Parser<Color> eyeColorParser = new Parser<Color>() {
        @Override
        public Color parse(String s) throws InvalidDataException {
            try{
                return Color.valueOf(s);
            } catch (IllegalArgumentException e){
                throw new InvalidDataException("Color not found! Please choose value from list!");
            }
        }
    };
    public static Parser<Country> nationalityParser = new Parser<Country>() {
        @Override
        public Country parse(String s) throws InvalidDataException {
            try{
                return Country.valueOf(s);
            } catch (IllegalArgumentException e){
                throw new InvalidDataException("Country not found! Please choose value from list!");
            }
        }
    };
}
