package ru.timur.Parsers;

import ru.timur.Exceptions.InvalidDataException;

@FunctionalInterface
public interface Parser {
    Object parse(String s) throws InvalidDataException;
}
