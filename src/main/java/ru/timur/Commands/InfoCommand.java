package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.UserIO;

public class InfoCommand extends UserCommand {
    private UserIO userIO;
    private CollectionController collectionController;
    public InfoCommand(UserIO userIO, CollectionController collectionController) {
        super("info", "print information about collection");
        this.userIO = userIO;
        this.collectionController = collectionController;
    }
    @Override
    public void execute(String[] commandArgs) {
        this.userIO.printLn(this.collectionController.getInfo());
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
