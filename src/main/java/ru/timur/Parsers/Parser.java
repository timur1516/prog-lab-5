package ru.timur.Parsers;

import ru.timur.Exceptions.InvalidDataException;

@FunctionalInterface
public interface Parser<T> {
    T parse(String s) throws InvalidDataException;
}
