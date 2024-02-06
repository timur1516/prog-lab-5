package ru.timur.Commands;

import ru.timur.Collection.Worker;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
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
    public void execute(String[] commandArgs) throws FieldInputException {
        collectionController.add((Worker) this.data);
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }

    @Override
    public void readData() throws FieldInputException {
        this.data = this.workerReader.readWorker();
    }
}
