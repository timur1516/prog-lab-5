package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.UserIO;

public class PrintFieldDescendingSalaryCommand extends UserCommand {
    private UserIO userIO;
    private CollectionController collectionController;
    public PrintFieldDescendingSalaryCommand(UserIO userIO, CollectionController collectionController) {
        super("print_field_descending_salary", "print values of all salary fields in collection in descending order");
        this.userIO = userIO;
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException {
        this.userIO.printLn(this.collectionController.getDescendingSalaries());
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
