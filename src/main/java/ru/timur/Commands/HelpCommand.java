package ru.timur.Commands;

import ru.timur.Controllers.CommandsController;
import ru.timur.Exceptions.WrongArgumentsException;
import ru.timur.UI.Console;

public class HelpCommand extends UserCommand {
    private CommandsController controller;
    public HelpCommand(CommandsController controller) {
        super("help", "print description of available commands");
        this.controller = controller;
    }

    @Override
    public void execute(String[] commandArgs) {
        this.controller.getCommandsList()
                .forEach(command -> Console.getInstance().printLn(command));
    }

    @Override
    public void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException {
        if(commandArgs.length != 0) throw new WrongArgumentsException("Wrong amount of arguments!");
    }
}
