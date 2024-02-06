package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.UserIO;

import java.util.NoSuchElementException;

public class MinBySalaryCommand extends UserCommand {
    private UserIO userIO;
    private CollectionController collectionController;
    public MinBySalaryCommand(UserIO userIO, CollectionController collectionController) {
        super("min_by_salary", "print any element from collection which salary field is minimal");
        this.userIO = userIO;
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws FieldInputException {
        if(this.collectionController.getCollection().isEmpty()){
            throw new NoSuchElementException("Collection is empty!");
        }
        this.userIO.printLn(this.collectionController.getMinBySalary());
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
