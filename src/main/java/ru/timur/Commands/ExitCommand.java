package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.UI.Console;
import ru.timur.UI.YesNoQuestionAsker;

public class ExitCommand extends UserCommand {
    private CollectionController collectionController;

    public ExitCommand(CollectionController collectionController) {
        super("exit", "stop program without saving collection");
        this.collectionController = collectionController;
    }

    @Override
    public void execute() throws InvalidDataException {
        if(this.collectionController.wasChanged()) {
            Console.getInstance().printLn("Last changes in collection aren't saved!");
        }
        YesNoQuestionAsker questionAsker = new YesNoQuestionAsker("Do you want to exit?");
        if(questionAsker.ask()) {
            System.exit(0);
        }
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0){
            throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
        }
    }
}
