package ru.timur.Exceptions;

public class WrongAmountOfArgumentsException extends IllegalArgumentException{
    private final int expectedArguments;
    private final int givenArguments;
    String message;

    public WrongAmountOfArgumentsException(String message, int expectedArguments, int givenArguments){
        super(message);
        this.expectedArguments = expectedArguments;
        this.givenArguments = givenArguments;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return String.format("%s Expected %d, got %d", message, expectedArguments, givenArguments);
    }
}
