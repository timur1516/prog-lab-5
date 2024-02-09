package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.Console;
import ru.timur.Collection.Readers.WorkerReader;

import java.time.LocalDateTime;

public class FilterLessThanEndDateCommand extends UserCommand {
    private WorkerReader workerReader;
    private CollectionController collectionController;
    public FilterLessThanEndDateCommand(WorkerReader workerReader, CollectionController collectionController) {
        super("filter_less_than_end_date", "endDate", "print all elements whose endDate is less than given");
        this.workerReader = workerReader;
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws InvalidDataException {
        Console.getInstance().printLn(this.collectionController.getLessThanEndDate((LocalDateTime) data));
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }

    @Override
    public void readData() throws InvalidDataException {
        this.data = this.workerReader.readEndDate();
    }
}
