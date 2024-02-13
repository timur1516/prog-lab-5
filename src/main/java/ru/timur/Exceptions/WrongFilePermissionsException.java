package ru.timur.Exceptions;

import java.io.FileNotFoundException;

public class WrongFilePermissionsException extends FileNotFoundException {
    public WrongFilePermissionsException(String message){
        super(message);
    }
}
