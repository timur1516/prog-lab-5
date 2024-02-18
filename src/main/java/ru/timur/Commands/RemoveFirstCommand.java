package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.UI.Console;

import java.util.NoSuchElementException;

public class RemoveFirstCommand extends UserCommand {
    private CollectionController collectionController;
    public RemoveFirstCommand(CollectionController collectionController) {
        super("remove_first", "remove first element from collection");
        this.collectionController = collectionController;
    }

    @Override
    public void execute() throws InvalidDataException {
        if(this.collectionController.getCollection().isEmpty()){
            Console.getInstance().printLn("Collection is empty!");
            return;
        }
        this.collectionController.removeFirst();
        Console.getInstance().printLn("Element removed successfully!");
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if (commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
