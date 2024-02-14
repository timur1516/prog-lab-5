package ru.timur;

import ru.timur.Collection.Readers.WorkerReader;
import ru.timur.Collection.Worker;
import ru.timur.Commands.UserCommand;
import ru.timur.Controllers.CollectionController;
import ru.timur.Controllers.CommandsController;
import ru.timur.Controllers.DataFileController;
import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.RecursiveScriptException;
import ru.timur.UI.Console;

import java.io.*;
import java.util.*;

/**
 * Main app class
 * Completes initialization of all controllers, set default input stream for Console
 * In the beginning load data file (if it is wrong program stops), then call interactiveMode method
 */
public class Main {
    /**
     * Path to json file with initial collection data
     * Is taken from Environmental variable
     */
    private static final String dataFilePath = System.getenv("ProgDataFile");
    /**
     * Controller of collection
     */
    private static CollectionController collectionController;
    /**
     * Reader of data elements
     */
    private static WorkerReader workerReader;
    /**
     * Controller of commands
     */
    private static CommandsController commandsController;
    /**
     * Controller of data file
     */
    private static DataFileController dataFileController = null;

    /**
     * Main method of program
     * Call methods to load data file, init all controllers and start handling user commands
     * @param args (not used)
     */
    public static void main(String[] args) {
        Console.getInstance().setScanner(new Scanner(System.in));
        collectionController = new CollectionController(loadData(dataFilePath));
        workerReader = new WorkerReader(collectionController);
        commandsController = new CommandsController(collectionController, workerReader, dataFileController);
        interactiveMode();
    }

    /**
     * method which is used to work with script file
     * @throws IOException If there are some problems with reading file
     * @throws RecursiveScriptException If completing script is recursive
     */
    public static void scriptMode() throws RecursiveScriptException, IOException {
        while(Console.getInstance().hasNextLine()) {
            String s = Console.getInstance().readLine();
            String[] input = (s.trim() + " ").split(" ");
            if(input.length == 0) continue;
            String commandName = input[0];
            Console.getInstance().printLn(commandName);
            String[] commandArgs = Arrays.copyOfRange(input, 1, input.length);
            UserCommand command = commandsController.launchCommand(commandName, commandArgs);
            command.execute(commandArgs);
        }
    }
    public static void interactiveMode(){
        while(Console.getInstance().hasNextLine()) {
            String s = Console.getInstance().readLine();
            String[] input = (s.trim() + " ").split(" ");
            if(input.length == 0) continue;
            String commandName = input[0];
            String[] commandArgs = Arrays.copyOfRange(input, 1, input.length);

            try {
                UserCommand command = commandsController.launchCommand(commandName, commandArgs);
                command.execute(commandArgs);
            }
            catch (Exception e){
                Console.getInstance().printError(e.getMessage());
            }
        }
    }
    private static PriorityQueue<Worker> loadData(String path){
        PriorityQueue<Worker> data = null;
        try {
            dataFileController = new DataFileController(dataFilePath);
        } catch (FileNotFoundException e) {
            Console.getInstance().printError("File not found!");
            System.exit(0);
        }
        try {
            data = dataFileController.readJSON();
        } catch (Exception e) {
            Console.getInstance().printError("Data file reading error!");
            System.exit(0);
        }
        if(!CollectionController.isValid(data)){
            Console.getInstance().printError("Data file is not valid!");
            System.exit(0);
        }
        return data;
    }
}