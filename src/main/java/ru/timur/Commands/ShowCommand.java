package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.UserIO;

public class ShowCommand extends UserCommand {
    private UserIO userIO;
    private CollectionController collectionController;
    public ShowCommand(UserIO userIO, CollectionController collectionController) {
        super("show", "print all elements of collection");
        this.userIO = userIO;
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws FieldInputException {
        if(this.collectionController.getCollection().isEmpty()){
            this.userIO.printLn("Collection is empty");
        }
        else {
            this.collectionController.getCollection()
                    .forEach(worker -> this.userIO.printLn(worker));
        }
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
