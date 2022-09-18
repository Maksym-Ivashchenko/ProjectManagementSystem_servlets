package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.ProjectsDto;
import ua.goit.jdbс.service.ProjectsService;
import ua.goit.jdbс.view.View;

public class FindProject implements Command {
    public static final String FIND_PROJECT = "find_project";
    private final View view;
    private final ProjectsService projectsService;

    public FindProject(View view, ProjectsService projectsService) {
        this.view = view;
        this.projectsService = projectsService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(FIND_PROJECT);
    }

    @Override
    public void execute() {
        view.write("Enter ID by project: ");
        int id = Integer.parseInt(view.read());
        while (true) {
            try {
                ProjectsDto project = projectsService.findById(id);
                System.out.println(project);
                break;
            } catch (RuntimeException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Project found. Thank you!");
    }
}
