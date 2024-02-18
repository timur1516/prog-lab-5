package ru.timur.Commands;

import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongAmountOfArgumentsException;

import java.util.Objects;

public abstract class UserCommand implements ICommand {
    /**
     * Command name
     */
    private final String name;
    /**
     * Command arguments in String format
     */
    private final String arguments;
    /**
     * Command description
     */
    private final String description;

    public UserCommand(String name, String description){
        this.name = name;
        this.arguments = "";
        this.description = description;
    }
    public UserCommand(String name, String arguments, String description){
        this.name = name;
        this.arguments = arguments;
        this.description = description;
    }
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Method to check and load arguments of command
     * @param commandArgs String array with different arguments
     * @throws WrongAmountOfArgumentsException If number of arguments is wrong for given command
     * @throws InvalidDataException if command argument are not valid
     */
    public abstract void initCommandArgs(String[] commandArgs) throws InvalidDataException, WrongAmountOfArgumentsException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCommand that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        String res = this.name;
        if(!this.arguments.isEmpty()) res += " " + this.arguments;
        res += ": " + this.description;
        return res;
    }
}
