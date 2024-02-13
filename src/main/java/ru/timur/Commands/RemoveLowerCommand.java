package ru.timur.Commands;

import ru.timur.Collection.Worker;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Collection.Readers.WorkerReader;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;

public class RemoveLowerCommand extends UserCommand {
    private WorkerReader workerReader;
    private CollectionController collectionController;
    public RemoveLowerCommand(WorkerReader workerReader, CollectionController collectionController) {
        super("remove_lower", "{element}", "remove all elements which are lower than given");
        this.workerReader = workerReader;
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException {
        Worker worker = this.workerReader.readWorker();
        this.collectionController.removeLower(worker);
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
