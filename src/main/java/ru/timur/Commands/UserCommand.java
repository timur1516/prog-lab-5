package ru.timur.Commands;

import ru.timur.Exceptions.InvalidDataException;
import ru.timur.Exceptions.WrongArgumentsException;

import java.io.IOException;
import java.util.Objects;

public abstract class UserCommand {
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

    protected Object data;
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
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }

    /**
     * This method completes action which command must do
     * @param commandArgs list of command arguments
     * @throws InvalidDataException if error while reading input values is occurred (useful in script mode)
     */
    public abstract void execute(String[] commandArgs) throws IOException, WrongArgumentsException;

    /**
     * This method check if command argument are correct
     * Method checks if amount of arguments is correct and if their type is correct
     * @param commandArgs list of command arguments
     * @throws WrongArgumentsException if arguments are wrong
     */
    public abstract void validateCommandArgs(String[] commandArgs) throws WrongArgumentsException;

    public void readData() throws InvalidDataException {
        this.data = null;
    }

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
