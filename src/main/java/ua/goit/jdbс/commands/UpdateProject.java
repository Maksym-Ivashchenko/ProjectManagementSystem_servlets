package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.ProjectsDto;
import ua.goit.jdbс.exceptions.ProjectAlreadyExistException;
import ua.goit.jdbс.service.ProjectsService;
import ua.goit.jdbс.view.View;

import java.time.LocalDate;

public class UpdateProject implements Command {
    public static final String UPDATE_PROJECT = "update_project";
    private final View view;
    private final ProjectsService projectsService;

    public UpdateProject(View view, ProjectsService projectsService) {
        this.view = view;
        this.projectsService = projectsService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(UPDATE_PROJECT);
    }

    @Override
    public void execute() {
        view.write("Enter ID by project: ");
        int id = Integer.parseInt(view.read());
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
        while (true) {
            try {
                view.write("Enter date created in format yyyy-mm-dd: ");
                dateCreated = LocalDate.parse(view.read());
                break;
            } catch (Exception e) {
                view.write("Invalid value. Use digits");
            }
        }
        while (true) {
            try {
                ProjectsDto project = new ProjectsDto(id, name, projectType, comments, cost, dateCreated);
                projectsService.update(project);
                break;
            } catch (ProjectAlreadyExistException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Project updated. Thank you!");
    }
}
