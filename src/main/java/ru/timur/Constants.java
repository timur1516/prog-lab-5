package ru.timur;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Stack;

public class Constants {
    public static boolean SCRIPT_MODE = false;
    public static final String DATE_FORMAT_STRING = "dd.MM.yyyy";
    public static final String TIME_FROMAT_STRING = "HH:mm";
    public static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern(DATE_FORMAT_STRING)
            .optionalStart()
            .appendPattern(" " + TIME_FROMAT_STRING)
            .optionalEnd()
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .toFormatter();
    public static Stack<String> scriptStack = new Stack<>();
}
