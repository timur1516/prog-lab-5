package ru.timur.Commands;

public interface ICommand {
    String getName();
    void execute() throws Exception;
}
