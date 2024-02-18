package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
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
    public void execute() throws InvalidDataException {
        LocalDateTime endDate = workerReader.readEndDate();
        Console.getInstance().printLn(this.collectionController.getLessThanEndDate(endDate));
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
