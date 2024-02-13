package ru.timur.Controllers;

import ru.timur.Commands.*;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.RecursiveScriptException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.Collection.Readers.WorkerReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class CommandsController {
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

    public CommandsController(CollectionController collectionController, WorkerReader workerReader, DataFileController dataFileController){
        HelpCommand helpCommand = new HelpCommand(this);
        this.infoCommand = new InfoCommand(collectionController);
        this.showCommand = new ShowCommand(collectionController);
        this.addCommand = new AddCommand(workerReader, collectionController);
        this.updateByIdCommand = new UpdateByIdCommand(workerReader, collectionController);
        this.removeByIdCommand = new RemoveByIdCommand(collectionController);
        this.clearCommand = new ClearCommand(collectionController);
        this.saveCommand = new SaveCommand(collectionController, dataFileController);
        this.executeScriptCommand = new ExecuteScriptCommand();
        this.exitCommand = new ExitCommand();
        this.removeFirstCommand = new RemoveFirstCommand(collectionController);
        this.removeGreaterCommand = new RemoveGreaterCommand(workerReader, collectionController);
        this.removeLowerCommand = new RemoveLowerCommand(workerReader, collectionController);
        this.minBySalaryCommand = new MinBySalaryCommand(collectionController);
        this.filterLessThanEndDateCommand = new FilterLessThanEndDateCommand(workerReader, collectionController);
        this.printFieldDescendingSalaryCommand = new PrintFieldDescendingSalaryCommand(collectionController);

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
     * Method to find command, validate its argument and read required data
     *
     * @param commandName String name of command to execute
     * @param commandArgs Array of String values with command arguments
     * @return UserCommand
     * @throws NoSuchElementException if there is no such command found
     * @throws InvalidDataException if error while reading data element happened (used for scriptMode)
     */
    public UserCommand launchCommand(String commandName, String[] commandArgs) throws WrongAmountOfArgumentsException, NoSuchElementException, InvalidDataException, FileNotFoundException, RecursiveScriptException {
        if(this.commandsList.stream().noneMatch(userCommand -> userCommand.getName().equals(commandName))){
            throw new NoSuchElementException("Command '" + commandName + "' not found!");
        }

        UserCommand command;

        command = this.commandsList
                .stream()
                .filter(userCommand -> userCommand.getName().equals(commandName))
                .findFirst().get();
        command.validateCommandArgs(commandArgs);

        return command;
    }
}
