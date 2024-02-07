package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongArgumentsException;
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
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 1){
            throw new WrongArgumentsException("Wrong amount of arguments!");
        }
        try {
            WorkerValidators.idValidator.validate(commandArgs[0]);
        } catch (InvalidDataException e) {
            throw new WrongArgumentsException("Wrong arguments format!");
        }
        if (!this.collectionController.containsId(Long.parseLong(commandArgs[0]))) {
            throw new NoSuchElementException("No element with such id!");
        }
    }
}
