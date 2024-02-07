package ru.timur;

import ru.timur.Collection.Readers.WorkerReader;
import ru.timur.Collection.Worker;
import ru.timur.Commands.UserCommand;
import ru.timur.Controllers.CollectionController;
import ru.timur.Controllers.CommandsController;
import ru.timur.Controllers.FileController;
import ru.timur.UI.*;

import java.io.*;
import java.util.*;

public class Main {
    private static String fileName = "C:\\Users\\hache\\IdeaProjects\\Lab5\\data\\data.json";
    private static UserIO userIO;
    private static CollectionController collectionController;
    private static WorkerReader workerReader;
    private static CommandsController commandsController;
    private static FileController fileController = null;

    public static void main(String[] args) {
        userIO = new UserIO(System.in);
        collectionController = new CollectionController(loadData(fileName));
        workerReader = new WorkerReader(userIO, collectionController);
        commandsController = new CommandsController(userIO, collectionController, workerReader, fileController);
        interactiveMode();
    }
    public static void scriptMode(String scriptfileName){
        boolean isCorrectScript = true;
        while(userIO.hasNextLine()){
            String s = userIO.readLine();
            String[] input = (s.trim() + " ").split(" ");
            if(input.length == 0) continue;
            String commandName = input[0];
            String[] commandArgs = Arrays.copyOfRange(input, 1, input.length);

            if(commandName.equals("execute_script") && commandArgs[0].equals(scriptfileName)){
                userIO.printError("Script can't be recursive!");
                isCorrectScript = false;
                break;
            }

            try {
                UserCommand command = commandsController.launchCommand(commandName, commandArgs);
            }
            catch (Exception e){
                userIO.printError("Invalid script!");
                isCorrectScript = false;
                break;
            }
        }
        if(isCorrectScript){
            try {
                userIO.setInputStream(new FileInputStream(scriptfileName));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            while(userIO.hasNextLine()) {
                String s = userIO.readLine();
                String[] input = (s.trim() + " ").split(" ");
                if(input.length == 0) continue;
                String commandName = input[0];
                String[] commandArgs = Arrays.copyOfRange(input, 1, input.length);
                userIO.printLn(commandName);
                try {
                    UserCommand command = commandsController.launchCommand(commandName, commandArgs);
                    command.execute(commandArgs);
                }
                catch (Exception e){
                    userIO.printError(e.getMessage());
                }
            }
        }
        Constants.SCRIPT_MODE = false;
        userIO.setInputStream(System.in);
        interactiveMode();
    }
    public static void interactiveMode(){
        while(userIO.hasNextLine()) {
            String s = userIO.readLine();
            String[] input = (s.trim() + " ").split(" ");
            if(input.length == 0) continue;
            String commandName = input[0];
            String[] commandArgs = Arrays.copyOfRange(input, 1, input.length);

            try {
                UserCommand command = commandsController.launchCommand(commandName, commandArgs);
                command.execute(commandArgs);
            }
            catch (Exception e){
                userIO.printError(e.getMessage());
            }
        }
    }
    private static PriorityQueue<Worker> loadData(String path){
        PriorityQueue<Worker> data = null;
        try {
            fileController = new FileController(fileName);
        } catch (FileNotFoundException e) {
            userIO.printError("File not found!");
            System.exit(0);
        }
        try {
            data = fileController.readJSON();
        } catch (Exception e) {
            userIO.printError("Data file reading error!");
            System.exit(0);
        }
        if(!CollectionController.isValid(data)){
            userIO.printError("Data file is not valid!");
            System.exit(0);
        }
        return data;
    }
}