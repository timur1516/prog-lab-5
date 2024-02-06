package ru.timur.Validators;

import ru.timur.Exceptions.FieldInputException;

@FunctionalInterface
public interface Validator {
    void validate(String s) throws FieldInputException;
}
