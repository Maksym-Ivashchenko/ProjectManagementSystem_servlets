package ua.goit.jdbсservlets.commands;

public interface Command {
    boolean canExecute(String input);

    void execute();
}
