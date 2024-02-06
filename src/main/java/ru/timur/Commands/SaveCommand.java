package ru.timur.Commands;

import ru.timur.Controllers.CollectionController;
import ru.timur.Controllers.FileController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;

import java.io.IOException;

public class SaveCommand extends UserCommand {
    private CollectionController collectionController;
    private FileController fileController;
    public SaveCommand(CollectionController collectionController, FileController fileController) {
        super("save", "save collection to data file");
        this.collectionController = collectionController;
        this.fileController = fileController;
    }

    @Override
    public void execute(String[] commandArgs) throws IOException {
        try {
            this.fileController.writeToJSON(this.collectionController.getCollection());
        } catch (IOException e) {
            throw new IOException("An error occurred while writing to the file!");
        }
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
