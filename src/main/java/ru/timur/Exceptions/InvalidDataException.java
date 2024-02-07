package ru.timur.Exceptions;

import java.io.IOException;

public class InvalidDataException extends IOException {
    public InvalidDataException(String message){
        super(message);
    }
}
