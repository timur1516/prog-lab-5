package ru.timur.Commands;

import ru.timur.Collection.Worker;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.Collection.Readers.WorkerReader;
import ru.timur.Validators.WorkerValidators;

import java.util.NoSuchElementException;

public class UpdateByIdCommand extends UserCommand {
    private WorkerReader workerReader;
    private CollectionController collectionController;
    public UpdateByIdCommand(WorkerReader workerReader, CollectionController collectionController) {
        super("update", "id {element}", "update value of collection element which id is equal to given");
        this.workerReader = workerReader;
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws FieldInputException{
        this.collectionController.update(Long.parseLong(commandArgs[0]), (Worker) data);
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException, NoSuchElementException {
        if (commandArgs.length != 1) throw new WrongArgumentsException("Wrong amount of arguments!");
        try {
            WorkerValidators.idValidator.validate(commandArgs[0]);
        } catch (FieldInputException e) {
            throw new WrongArgumentsException("Wrong arguments format!");
        }
        if (!this.collectionController.containsId(Long.parseLong(commandArgs[0]))) {
            throw new NoSuchElementException("No element with such id!");
        }
    }

    @Override
    public void readData() throws FieldInputException {
        this.data = this.workerReader.readWorker();
    }
}
