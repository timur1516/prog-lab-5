package ru.timur.Commands;

import ru.timur.Collection.Worker;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Collection.Readers.WorkerReader;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.UI.Console;

import java.util.NoSuchElementException;

public class RemoveLowerCommand extends UserCommand {
    private WorkerReader workerReader;
    private CollectionController collectionController;
    public RemoveLowerCommand(WorkerReader workerReader, CollectionController collectionController) {
        super("remove_lower", "{element}", "remove all elements which are lower than given");
        this.workerReader = workerReader;
        this.collectionController = collectionController;
    }

    @Override
    public void execute() throws InvalidDataException {
        if(this.collectionController.getCollection().isEmpty()){
            throw new NoSuchElementException("Collection is empty!");
        }
        Worker worker = this.workerReader.readWorker();
        int elementsRemoved = this.collectionController.removeLower(worker);
        Console.getInstance().printLn(String.format("Successfully removed %d elements!", elementsRemoved));
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
