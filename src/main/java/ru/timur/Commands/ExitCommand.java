package ru.timur.Commands;

import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.UI.Console;
import ru.timur.UI.YesNoQuestionAsker;

public class ExitCommand extends UserCommand {

    public ExitCommand() {
        super("exit", "stop program without saving collection");
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException {
        Console.getInstance().printLn("Please, make sure that current collection is saved");
        YesNoQuestionAsker questionAsker = new YesNoQuestionAsker("Do you want to exit?");
        if(questionAsker.ask()) {
            System.exit(0);
        }
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0){
            throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
        }
    }
}
