package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.Console;

public class InfoCommand extends UserCommand {
    private CollectionController collectionController;
    public InfoCommand(CollectionController collectionController) {
        super("info", "print information about collection");
        this.collectionController = collectionController;
    }
    @Override
    public void execute(String[] commandArgs) {
        Console.getInstance().printLn(this.collectionController.getInfo());
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
