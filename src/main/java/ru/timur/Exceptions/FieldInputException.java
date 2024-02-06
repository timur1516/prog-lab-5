package ru.timur.Exceptions;

import java.io.IOException;

public class FieldInputException extends IOException {
    public FieldInputException(String message){
        super(message);
    }
}
