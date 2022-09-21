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
        view.write("Enter developer name, age, gender, email and salary separated by a '/': ");
        String[] developerColumns = view.read().split("/");
        String name;
        int age = -1;
        String gender;
        String different;
        int salary = -1;
        if (developerColumns.length == developersService.getCountOfColumn() - 1) {
            for (int i = 0; i <= developerColumns.length - 1; i++) {
                String s = developerColumns[i].replace(",", "").strip();
                developerColumns[i] = s;
            }
            name = developerColumns[0];
            try {
                age = Integer.parseInt(developerColumns[1]);
            } catch (NumberFormatException e) {
                view.write("Invalid value. Use digits");
            }
            if (age == -1) {
                view.write("Developer not added. Try again.");
            } else if (age > 0) {
                gender = developerColumns[2];
                different = developerColumns[3];
                try {
                    salary = Integer.parseInt(developerColumns[4]);
                } catch (NumberFormatException e) {
                    view.write("Invalid value. Use digits");
                }
                if (salary == -1) {
                    view.write("Developer not added. Try again.");
                } else {
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
            } else {
                view.write("Developer not added. Try again.");
            }
        }
    }
}