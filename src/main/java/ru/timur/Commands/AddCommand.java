package ru.timur.Commands;

import ru.timur.Collection.Worker;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.Collection.Readers.WorkerReader;

public class AddCommand extends UserCommand {
    private CollectionController collectionController;
    private WorkerReader workerReader;
    public AddCommand(WorkerReader workerReader, CollectionController collectionController) {
        super("add", "{element}", "add new element to collection");
        this.collectionController = collectionController;
        this.workerReader = workerReader;
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException {
        Worker worker = this.workerReader.readWorker();
        collectionController.add(worker);
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
