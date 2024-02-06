package ru.timur.Commands;

import ru.timur.Controllers.CommandsController;
import ru.timur.Exceptions.FieldInputException;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.UserIO;

public class HelpCommand extends UserCommand {
    private CommandsController controller;
    private UserIO userIO;
    public HelpCommand(UserIO userIO, CommandsController controller) {
        super("help", "print description of available commands");
        this.controller = controller;
        this.userIO = userIO;
    }

    @Override
    public void execute(String[] commandArgs) {
        this.controller.getCommandsList()
                .forEach(command -> this.userIO.printLn(command));
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
