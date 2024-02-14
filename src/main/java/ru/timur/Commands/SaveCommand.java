package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Controllers.DataFileController;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.UI.Console;

import java.io.IOException;

public class SaveCommand extends UserCommand {
    private CollectionController collectionController;
    private DataFileController dataFileController;
    public SaveCommand(CollectionController collectionController, DataFileController dataFileController) {
        super("save", "save collection to data file");
        this.collectionController = collectionController;
        this.dataFileController = dataFileController;
    }

    @Override
    public void execute(String[] commandArgs) throws IOException {
        try {
            this.dataFileController.writeToJSON(this.collectionController.getCollection());
            Console.getInstance().printLn("Collection saved successfully!");
        } catch (IOException e) {
            throw new IOException("An error occurred while writing to the file!");
        }
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
