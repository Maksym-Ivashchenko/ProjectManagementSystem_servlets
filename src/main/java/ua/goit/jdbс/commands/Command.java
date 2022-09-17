package ua.goit.jdbс.commands;

public interface Command {
    boolean canExecute(String input);

    void execute();
}
