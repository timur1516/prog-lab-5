package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.UI.Console;

import java.util.NoSuchElementException;

public class MinBySalaryCommand extends UserCommand {
    private CollectionController collectionController;
    public MinBySalaryCommand(CollectionController collectionController) {
        super("min_by_salary", "print any element from collection which salary field is minimal");
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException {
        if(this.collectionController.getCollection().isEmpty()){
            throw new NoSuchElementException("Collection is empty!");
        }
        Console.getInstance().printLn(this.collectionController.getMinBySalary());
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
