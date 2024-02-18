package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.UI.Console;

public class InfoCommand extends UserCommand {
    private CollectionController collectionController;
    public InfoCommand(CollectionController collectionController) {
        super("info", "print information about collection");
        this.collectionController = collectionController;
    }
    @Override
    public void execute() {
        Console.getInstance().printLn(this.collectionController.getInfo());
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
