package ru.timur.Validators;

import ru.timur.Exceptions.InvalidDataException;

@FunctionalInterface
public interface Validator<T> {
    void validate(T value) throws InvalidDataException;
}