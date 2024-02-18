package ru.timur.Commands;

import ru.timur.Collection.Worker;
import ru.timur.Constants;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Collection.Readers.WorkerReader;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.UI.Console;

import java.util.NoSuchElementException;

public class RemoveGreaterCommand extends UserCommand {
    private WorkerReader workerReader;
    private CollectionController collectionController;
    public RemoveGreaterCommand(WorkerReader workerReader, CollectionController collectionController) {
        super("remove_greater", "{element}", "remove all elements which are greater than given");
        this.workerReader = workerReader;
        this.collectionController = collectionController;
    }

    @Override
    public void execute() throws InvalidDataException {
        if(this.collectionController.getCollection().isEmpty()){
            Console.getInstance().printLn("Collection is empty!");
            if(Constants.SCRIPT_MODE){
                workerReader.readWorker();
            }
            return;
        }

        Worker worker = this.workerReader.readWorker();
        int elementsRemoved = this.collectionController.removeGreater(worker);
        Console.getInstance().printLn(String.format("Successfully removed %d elements!", elementsRemoved));
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
