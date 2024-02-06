package ru.timur.Commands;

import ru.timur.Collection.Worker;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.Collection.Readers.WorkerReader;

public class RemoveLowerCommand extends UserCommand {
    private WorkerReader workerReader;
    private CollectionController collectionController;
    public RemoveLowerCommand(WorkerReader workerReader, CollectionController collectionController) {
        super("remove_lower", "{element}", "remove all elements which are lower than given");
        this.workerReader = workerReader;
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws FieldInputException {
        this.collectionController.removeLower((Worker) data);
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
