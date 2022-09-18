package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.DevelopersDto;
import ua.goit.jdbс.exceptions.DeveloperAlreadyExistException;
import ua.goit.jdbс.service.DevelopersService;
import ua.goit.jdbс.view.View;

public class UpdateDeveloper implements Command {
    public static final String UPDATE_DEVELOPER = "update_developer";
    private final View view;
    private final DevelopersService developersService;

    public UpdateDeveloper(View view, DevelopersService developersService) {
        this.view = view;
        this.developersService = developersService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(UPDATE_DEVELOPER);
    }

    @Override
    public void execute() {
        view.write("Enter ID by developer: ");
        int id = Integer.parseInt(view.read());
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
                DevelopersDto developer = new DevelopersDto(id, name, age, gender, different, salary);
                developersService.update(developer);
                break;
            } catch (DeveloperAlreadyExistException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Developer updated. Thank you!");
    }
}
