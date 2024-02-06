package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;

public class ClearCommand extends UserCommand {
    private CollectionController collectionController;
    public ClearCommand(CollectionController collectionController) {
        super("clear", "delete all element from collection");
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws FieldInputException {
        this.collectionController.clear();
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0){
            throw new WrongArgumentsException("Wrong amount of arguments!");
        }
    }
}
