package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;

import java.util.NoSuchElementException;

public class RemoveFirstCommand extends UserCommand {
    private CollectionController collectionController;
    public RemoveFirstCommand(CollectionController collectionController) {
        super("remove_first", "remove first element from collection");
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException, NoSuchElementException {
        if(this.collectionController.getCollection().isEmpty()){
            throw new NoSuchElementException("Collection is empty!");
        }
        this.collectionController.removeFirst();
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if (commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
