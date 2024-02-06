package ru.timur.Controllers;

import ru.timur.Commands.*;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.UserIO;
import ru.timur.Collection.Readers.WorkerReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class CommandsController {
    private final HelpCommand helpCommand;
    private final InfoCommand infoCommand;
    private final ShowCommand showCommand;
    private final AddCommand addCommand;
    private final UpdateByIdCommand updateByIdCommand;
    private final RemoveByIdCommand removeByIdCommand;
    private final ClearCommand clearCommand;
    private final SaveCommand saveCommand;
    private final ExecuteScriptCommand executeScriptCommand;
    private final ExitCommand exitCommand;
    private final RemoveFirstCommand removeFirstCommand;
    private final RemoveGreaterCommand removeGreaterCommand;
    private final RemoveLowerCommand removeLowerCommand;
    private final MinBySalaryCommand minBySalaryCommand;
    private final FilterLessThanEndDateCommand filterLessThanEndDateCommand;
    private final PrintFieldDescendingSalaryCommand printFieldDescendingSalaryCommand;

    private final ArrayList<UserCommand> commandsList;

    public CommandsController(UserIO userIO, CollectionController collectionController, WorkerReader workerReader, FileController fileController){
        this.helpCommand = new HelpCommand(userIO, this);
        this.infoCommand = new InfoCommand(userIO, collectionController);
        this.showCommand = new ShowCommand(userIO, collectionController);
        this.addCommand = new AddCommand(workerReader, collectionController);
        this.updateByIdCommand = new UpdateByIdCommand(workerReader, collectionController);
        this.removeByIdCommand = new RemoveByIdCommand(collectionController);
        this.clearCommand = new ClearCommand(collectionController);
        this.saveCommand = new SaveCommand(collectionController, fileController);
        this.executeScriptCommand = new ExecuteScriptCommand(userIO);
        this.exitCommand = new ExitCommand();
        this.removeFirstCommand = new RemoveFirstCommand(collectionController);
        this.removeGreaterCommand = new RemoveGreaterCommand(workerReader, collectionController);
        this.removeLowerCommand = new RemoveLowerCommand(workerReader, collectionController);
        this.minBySalaryCommand = new MinBySalaryCommand(userIO, collectionController);
        this.filterLessThanEndDateCommand = new FilterLessThanEndDateCommand(userIO, workerReader, collectionController);
        this.printFieldDescendingSalaryCommand = new PrintFieldDescendingSalaryCommand(userIO, collectionController);

        this.commandsList  = new ArrayList<>(Arrays.asList(
                helpCommand,
                infoCommand,
                showCommand,
                addCommand,
                updateByIdCommand,
                removeByIdCommand,
                clearCommand,
                saveCommand,
                executeScriptCommand,
                exitCommand,
                removeFirstCommand,
                removeGreaterCommand,
                removeLowerCommand,
                minBySalaryCommand,
                filterLessThanEndDateCommand,
                printFieldDescendingSalaryCommand
        ));
    }

    public ArrayList<UserCommand> getCommandsList() {
        return commandsList;
    }

    /**
     * This method finds command in list of commands, validates its arguments and that executes it
     * @throws NoSuchElementException if there is no such command found
     * @throws WrongArgumentsException if wrong arguments given
     * @throws FieldInputException in case of wrong input while executing (works in script mode)
     * @param commandName String name of command to execute
     * @param commandArgs Array of String values with command arguments
     */
    public void findAndExecute(String commandName, String[] commandArgs) throws NoSuchElementException, WrongArgumentsException, IOException {
        if(!this.commandsList.stream().anyMatch(userCommand -> userCommand.getName().equals(commandName))){
            throw new NoSuchElementException("Command '" + commandName + "' not found!");
        }
        UserCommand command;
        command = this.commandsList
                .stream()
                .filter(userCommand -> userCommand.getName().equals(commandName))
                .findFirst().get();
        command.validateCommandArgs(commandArgs);
        command.execute(commandArgs);
    }
}
