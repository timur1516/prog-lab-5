package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.Parsers.WorkerParsers;
import ru.timur.UI.Console;
import ru.timur.Validators.WorkerValidators;

import java.util.NoSuchElementException;

public class RemoveByIdCommand extends UserCommand {
    private CollectionController collectionController;

    public RemoveByIdCommand(CollectionController collectionController) {
        super("remove_by_id", "id", "remove element with given id from collection");
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException {
        this.collectionController.removeById(Long.parseLong(commandArgs[0]));
        Console.getInstance().printLn("Element removed successfully!");
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException, InvalidDataException {
        if(commandArgs.length != 1){
            throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 1, commandArgs.length);
        }
        long id = (Long) WorkerParsers.longParser.parse(commandArgs[0]);
        WorkerValidators.idValidator.validate(id);
        if (!this.collectionController.containsId(Long.parseLong(commandArgs[0]))) {
            throw new NoSuchElementException("No element with such id!");
        }
    }
}
