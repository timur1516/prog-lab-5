package ru.timur.Commands;

import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongArgumentsException;

public class ExitCommand extends UserCommand {

    public ExitCommand() {
        super("exit", "stop program without saving collection");
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException {
        System.exit(0);
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0){
            throw new WrongArgumentsException("Wrong amount of arguments!");
        }
    }
}
