package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.UserIO;
import ru.timur.Collection.Readers.WorkerReader;

import java.time.LocalDateTime;

public class FilterLessThanEndDateCommand extends UserCommand {
    private UserIO userIO;
    private WorkerReader workerReader;
    private CollectionController collectionController;
    public FilterLessThanEndDateCommand(UserIO userIO, WorkerReader workerReader, CollectionController collectionController) {
        super("filter_less_than_end_date", "endDate", "print all elements whose endDate is less than given");
        this.userIO = userIO;
        this.workerReader = workerReader;
        this.collectionController = collectionController;
    }

    @Override
    public void execute(String[] commandArgs) throws FieldInputException {
        this.userIO.printLn(this.collectionController.getLessThanEndDate((LocalDateTime) data));
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }

    @Override
    public void readData() throws FieldInputException {
        this.data = this.workerReader.readEndDate();
    }
}
