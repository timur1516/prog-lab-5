package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.Console;

public class ShowCommand extends UserCommand {
    private CollectionController collectionController;
    public ShowCommand(CollectionController collectionController) {
        super("show", "print all elements of collection");
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException {
        if(this.collectionController.getCollection().isEmpty()){
            Console.getInstance().printLn("Collection is empty");
        }
        else {
            this.collectionController.getCollection()
                    .forEach(worker -> Console.getInstance().printLn(worker));
        }
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
