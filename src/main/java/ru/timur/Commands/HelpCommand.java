package ru.timur.Commands;

import ru.timur.Controllers.CommandsController;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;
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
    public void validateCommandArgs(String[] commandArgs) throws WrongAmountOfArgumentsException {
        if(commandArgs.length != 0) throw new WrongAmountOfArgumentsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
