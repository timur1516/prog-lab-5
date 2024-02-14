package ru.timur.Commands;

import ru.timur.Collection.Worker;
import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.Collection.Readers.WorkerReader;
import ru.timur.Parsers.WorkerParsers;
import ru.timur.UI.Console;
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
    public void execute(String[] commandArgs) throws InvalidDataException {
        Worker worker = this.workerReader.readWorker();
        this.collectionController.update(Long.parseLong(commandArgs[0]), worker);
        Console.getInstance().printLn("Element updated successfully!");
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException, InvalidDataException {
        if (commandArgs.length != 1) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 1, commandArgs.length);
        long id = (Long) WorkerParsers.longParser.parse(commandArgs[0]);
        WorkerValidators.idValidator.validate(id);
        if (!this.collectionController.containsId(Long.parseLong(commandArgs[0]))) {
            throw new NoSuchElementException("No element with such id!");
        }
    }
}
