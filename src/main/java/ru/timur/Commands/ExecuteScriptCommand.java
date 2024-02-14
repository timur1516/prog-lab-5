package ru.timur.Commands;

import ru.timur.Constants;
import ru.timur.Exceptions.RecursiveScriptException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
import ru.timur.Exceptions.WrongFilePermissionsException;
import ru.timur.Main;
import ru.timur.UI.Console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExecuteScriptCommand extends UserCommand {
    public ExecuteScriptCommand() {
        super("execute_script", "file_name", "read and execute script from given file");
    }

    @Override
    public void execute(String[] commandArgs) throws IOException, RecursiveScriptException {
        Constants.scriptStack.push(commandArgs[0]);
        Scanner prevScanner = Console.getInstance().getScanner();
        Console.getInstance().setScanner(new Scanner(new FileInputStream(commandArgs[0])));
        Constants.SCRIPT_MODE = true;
        try {
            Main.scriptMode();
            Console.getInstance().printLn("Script executed successfully!");
        } finally {
            Constants.scriptStack.pop();
            Constants.SCRIPT_MODE = false;
            Console.getInstance().setScanner(prevScanner);
        }
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException, FileNotFoundException, RecursiveScriptException {
        if(commandArgs.length != 1) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 1, commandArgs.length);
        Path path = Paths.get(commandArgs[0]);
        if(!Files.exists(path)){
            throw new FileNotFoundException("Script file does not exists!");
        }
        if(Files.isDirectory(path)){
            throw new FileNotFoundException("Given path is a directory!");
        }
        if(!commandArgs[0].substring(commandArgs[0].length() - 4).equals(".txt")){
            throw new FileNotFoundException("Script file must be .txt!");
        }
        if(!Files.isReadable(path)){
            throw new WrongFilePermissionsException("Wrong script file permissions! File is not readable!");
        }
        if(!Constants.scriptStack.isEmpty() && Constants.scriptStack.contains(commandArgs[0])){
            throw new RecursiveScriptException("Script is recursive!");
        }
    }
}
