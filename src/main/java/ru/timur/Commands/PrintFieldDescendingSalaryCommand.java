package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.UI.Console;

public class PrintFieldDescendingSalaryCommand extends UserCommand {
    private CollectionController collectionController;
    public PrintFieldDescendingSalaryCommand(CollectionController collectionController) {
        super("print_field_descending_salary", "print values of all salary fields in collection in descending order");
        this.collectionController = collectionController;
    }

    @Override
    public void execute() throws InvalidDataException {
        if(this.collectionController.getCollection().isEmpty()){
            Console.getInstance().printLn("Collection is empty!");
            return;
        }
        Console.getInstance().printLn(this.collectionController.getDescendingSalaries());
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
