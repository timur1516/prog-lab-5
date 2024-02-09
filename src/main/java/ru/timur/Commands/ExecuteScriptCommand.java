package ru.timur.Commands;

import ru.timur.Constants;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.Main;
import ru.timur.UI.Console;

import javax.script.ScriptException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteScriptCommand extends UserCommand {
    public ExecuteScriptCommand() {
        super("execute_script", "file_name", "read and execute script from given file");
    }

    @Override
    public void execute(String[] commandArgs) throws IOException, WrongArgumentsException {
        Main.scriptStack.push(commandArgs[0]);
        Scanner prevScanner = Console.getInstance().getScanner();
        Console.getInstance().setScanner(new Scanner(new FileInputStream(commandArgs[0])));
        Constants.SCRIPT_MODE = true;
        try {
            Main.scriptMode(commandArgs[0]);
        } finally {
            Main.scriptStack.pop();
            Constants.SCRIPT_MODE = false;
            Console.getInstance().setScanner(prevScanner);
        }
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 1) throw new WrongArgumentsException("Wrong amount of arguments!");
        try {
            new FileInputStream(commandArgs[0]);
            if(!Main.scriptStack.isEmpty() && Main.scriptStack.contains(commandArgs[0])){
                throw new WrongArgumentsException("Script in recursive!");
            }
        } catch (FileNotFoundException e){
            throw new WrongArgumentsException("Wrong path to script file");
        }
    }
}
