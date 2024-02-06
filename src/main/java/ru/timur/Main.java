package ru.timur;

import ru.timur.Collection.Readers.WorkerReader;
import ru.timur.Collection.Worker;
import ru.timur.Controllers.CollectionController;
import ru.timur.Controllers.CommandsController;
import ru.timur.Controllers.FileController;
import ru.timur.Exceptions.InvalidDataException;
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
    private static void scriptMode(){
        while(userIO.hasNextLine()){

        }
    }
    private static void interactiveMode(){
        do {
            String s = userIO.readLine();
            String[] input = (s.trim() + " ").split(" ");
            if(input.length == 0) continue;
            String commandName = input[0];
            String[] commandArgs = Arrays.copyOfRange(input, 1, input.length);

            try {
                commandsController.findAndExecute(commandName, commandArgs);
            }
            catch (Exception e){
                userIO.printError(e.getMessage());
            }
        }while (true);
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