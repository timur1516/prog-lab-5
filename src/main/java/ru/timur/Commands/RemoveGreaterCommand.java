package ru.timur.Commands;

import ru.timur.Collection.Worker;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.Collection.Readers.WorkerReader;

public class RemoveGreaterCommand extends UserCommand {
    private WorkerReader workerReader;
    private CollectionController collectionController;
    public RemoveGreaterCommand(WorkerReader workerReader, CollectionController collectionController) {
        super("remove_greater", "{element}", "remove all elements which are greater than given");
        this.workerReader = workerReader;
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws FieldInputException {
        Worker worker = this.workerReader.readWorker();
        this.collectionController.removeGreater(worker);
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
