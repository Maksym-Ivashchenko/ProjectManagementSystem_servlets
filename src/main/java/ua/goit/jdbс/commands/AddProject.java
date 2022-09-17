package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.DevelopersDto;
import ua.goit.jdbс.exceptions.DeveloperAlreadyExistException;
import ua.goit.jdbс.service.DevelopersService;
import ua.goit.jdbс.service.ProjectsService;
import ua.goit.jdbс.view.View;

import java.time.LocalDate;
import java.util.Date;

public class AddProject implements Command {
    public static final String ADD_PROJECT = "add_project";
    private final View view;
    private final ProjectsService projectsService;

    public AddProject(View view, ProjectsService projectsService) {
        this.view = view;
        this.projectsService = projectsService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(ADD_PROJECT);
    }

    @Override
    public void execute() {
        view.write("Enter project name: ");
        String name = view.read();
        view.write("Enter project type: ");
        String projectType = view.read();
        view.write("Enter comments: ");
        String comments = view.read();
        int cost = -1;
        while (true) {
            try {
                view.write("Enter cost: ");
                cost = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException e) {
                view.write("Invalid value. Use digits");
            }
        }
        LocalDate dateCreated;
//        while (true) {
//            try {
//                DevelopersDto developer = new DevelopersDto(name, cost, gender, different, salary);
//                projectsService.save(developer);
//                break;
//            } catch (DeveloperAlreadyExistException exception) {
//                view.write(exception.getMessage());
//            }
//        }
        view.write("Developer added. Thank you!");
    }
}