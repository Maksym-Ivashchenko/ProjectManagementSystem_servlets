package ua.goit.jdbс.commands;

import ua.goit.jdbс.view.View;

public class Help implements Command {
    private static final String HELP = "help";
    private final View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(HELP);
    }

    @Override
    public void execute() {
        view.write(String.format("Enter %s to see all command", Help.HELP));
        view.write(String.format("Enter %s to exit program", Exit.EXIT));
        view.write(String.format("Enter %s command to add developer to the DB", AddDeveloper.ADD_DEVELOPER));
        view.write(String.format("Enter %s command to update developer to the DB", UpdateDeveloper.UPDATE_DEVELOPER));
        view.write(String.format("Enter %s command to delete developer from DB", DeleteDeveloper.DELETE_DEVELOPER));
        view.write(String.format("Enter %s command to find developer from DB", FindDeveloper.FIND_DEVELOPER));

        view.write(String.format("Enter %s command to get a list of all Java developers", Task3.TASK_3));
        view.write(String.format("Enter %s command to get a list of all Middle developers", Task4.TASK_4));


//        view.write(String.format("Enter %s command to add journal to the library", "add journal"));
    }
}
