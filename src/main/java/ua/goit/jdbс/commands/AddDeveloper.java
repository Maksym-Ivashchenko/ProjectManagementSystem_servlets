package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.DevelopersDto;
import ua.goit.jdbс.exceptions.DeveloperAlreadyExistException;
import ua.goit.jdbс.service.DevelopersService;
import ua.goit.jdbс.view.View;

public class AddDeveloper implements Command {
    public static final String ADD_DEVELOPER = "add_developer";
    private final View view;
    private final DevelopersService developersService;

    public AddDeveloper(View view, DevelopersService developersService) {
        this.view = view;
        this.developersService = developersService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(ADD_DEVELOPER);
    }

    @Override
    public void execute() {
        view.write("Enter developer name: ");
        String name = view.read();
        int age = -1;
        while (true) {
            try {
                view.write("Enter age: ");
                age = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException e) {
                view.write("Invalid value. Use digits");
            }
        }
        view.write("Enter gender: ");
        String gender = view.read();
        view.write("Enter additional information (e.g. email)");
        String different = view.read();
        int salary = -1;
        while (true) {
            try {
                view.write("Enter salary: ");
                salary = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException e) {
                view.write("Invalid value. Use digits");
            }
        }

        while (true) {
            try {
                DevelopersDto developer = new DevelopersDto(name, age, gender, different, salary);
                developersService.save(developer);
                break;
            } catch (DeveloperAlreadyExistException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Developer added. Thank you!");
    }
}