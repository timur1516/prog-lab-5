package ru.timur.Validators;

import ru.timur.Exceptions.InvalidDataException;

@FunctionalInterface
public interface Validator {
    void validate(Object value) throws InvalidDataException;
}