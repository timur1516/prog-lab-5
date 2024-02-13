package ru.timur;

import ru.timur.Collection.Readers.WorkerReader;
import ru.timur.Collection.Worker;
import ru.timur.Commands.UserCommand;
import ru.timur.Controllers.CollectionController;
import ru.timur.Controllers.CommandsController;
import ru.timur.Controllers.DataFileController;
import ru.timur.Exceptions.RecursiveScriptException;
import ru.timur.UI.Console;

import java.io.*;
import java.util.*;

public class Main {
    private static String fileName = "C:\\Users\\hache\\IdeaProjects\\Lab5\\data\\data.json";
    private static CollectionController collectionController;
    private static WorkerReader workerReader;
    private static CommandsController commandsController;
    private static DataFileController dataFileController = null;

    public static void main(String[] args) {
        Console.getInstance().setScanner(new Scanner(System.in));
        collectionController = new CollectionController(loadData(fileName));
        workerReader = new WorkerReader(collectionController);
        commandsController = new CommandsController(collectionController, workerReader, dataFileController);
        interactiveMode();
    }
    public static void scriptMode() throws IOException, RecursiveScriptException {
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
            dataFileController = new DataFileController(fileName);
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