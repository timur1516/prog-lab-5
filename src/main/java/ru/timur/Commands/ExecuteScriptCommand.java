package ru.timur.Commands;

import ru.timur.Constants;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.Main;
import ru.timur.UI.UserIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExecuteScriptCommand extends UserCommand {
    private UserIO userIO;
    public ExecuteScriptCommand(UserIO userIO) {
        super("execute_script", "file_name", "read and execute script from given file");
        this.userIO = userIO;
    }

    @Override
    public void execute(String[] commandArgs) throws FileNotFoundException {
        this.userIO.setInputStream(new FileInputStream(commandArgs[0]));
        Constants.SCRIPT_MODE = true;
        Main.scriptMode(commandArgs[0]);
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 1) throw new WrongArgumentsException("Wrong amount of arguments!");
        try {
            new FileInputStream(commandArgs[0]);
        } catch (FileNotFoundException e){
            throw new WrongArgumentsException("Wrong path to script file");
        }
    }
}
