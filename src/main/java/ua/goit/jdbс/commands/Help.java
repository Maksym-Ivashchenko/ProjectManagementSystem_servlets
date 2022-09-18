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
        view.write(String.format("Enter %s command to add project to the DB", AddProject.ADD_PROJECT));
        view.write(String.format("Enter %s command to update project to the DB", UpdateProject.UPDATE_PROJECT));
        view.write(String.format("Enter %s command to delete project from DB", DeleteProject.DELETE_PROJECT));
        view.write(String.format("Enter %s command to find project from DB", FindProject.FIND_PROJECT));
        view.write(String.format("Enter %s command to add company to the DB", AddCompany.ADD_COMPANY));
        view.write(String.format("Enter %s command to update company to the DB", UpdateCompany.UPDATE_COMPANY));
        view.write(String.format("Enter %s command to delete company from DB", DeleteCompany.DELETE_COMPANY));
        view.write(String.format("Enter %s command to find company from DB", FindCompany.FIND_COMPANY));
        view.write(String.format("Enter %s command to add customer to the DB", AddCustomer.ADD_CUSTOMER));
        view.write(String.format("Enter %s command to update customer to the DB", UpdateCustomer.UPDATE_CUSTOMER));
        view.write(String.format("Enter %s command to delete customer from DB", DeleteCustomer.DELETE_CUSTOMER));
        view.write(String.format("Enter %s command to find customer from DB", FindCustomer.FIND_CUSTOMER));
        view.write(String.format("Enter %s command to add skill to the DB", AddSkill.ADD_SKILL));
        view.write(String.format("Enter %s command to update skill to the DB", UpdateSkill.UPDATE_SKILL));
        view.write(String.format("Enter %s command to delete skill from DB", DeleteSkill.DELETE_SKILL));
        view.write(String.format("Enter %s command to find skill from DB", FindSkill.FIND_SKILL));
        view.write(String.format("Enter %s command to get a salary (sum) of all developers of a separate project",
                Task1.TASK_1));
        view.write(String.format("Enter %s command to get a list of developers from project", Task2.TASK_2));
        view.write(String.format("Enter %s command to get a list of all Java developers", Task3.TASK_3));
        view.write(String.format("Enter %s command to get a list of all Middle developers", Task4.TASK_4));
        view.write(String.format("Enter %s command to get a list of projects in the format", Task5.TASK_5));
    }
}
