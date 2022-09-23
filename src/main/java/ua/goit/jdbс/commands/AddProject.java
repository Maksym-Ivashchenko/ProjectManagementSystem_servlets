package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.ProjectsDto;
import ua.goit.jdbс.exceptions.ProjectAlreadyExistException;
import ua.goit.jdbс.repository.ProjectsRepository;
import ua.goit.jdbс.service.ProjectsService;
import ua.goit.jdbс.view.View;

import java.time.LocalDate;

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
        view.write("Enter project name, type, comments, cost and date created in yyyy-mm-dd format separated by a '/': ");
        String[] projectColumns = view.read().split("/");
        String name;
        String projectType;
        String comments;
        int cost = -1;
        LocalDate dateCreated = null;
        if (projectColumns.length == projectsService.getCountOfColumn(ProjectsRepository.TABLE_NAME) - 1) {
            for (int i = 0; i <= projectColumns.length - 1; i++) {
                String s = projectColumns[i].replace(",", "").strip();
                projectColumns[i] = s;
            }
            name = projectColumns[0];
            projectType = projectColumns[1];
            comments = projectColumns[2];
            try {
                cost = Integer.parseInt(projectColumns[3]);
            } catch (NumberFormatException e) {
                view.write("Invalid value. Use digits");
            }
            if (cost == -1) {
                view.write("Project not added. Try again.");
            } else if (cost > 0) {
                try {
                    dateCreated = LocalDate.parse(projectColumns[4]);
                } catch (Exception e) {
                    view.write("Invalid value. Use digits");
                }
                if (dateCreated == null) {
                    view.write("Project not added. Try again.");
                } else {
                    while (true) {
                        try {
                            ProjectsDto project = new ProjectsDto(name, projectType, comments, cost, dateCreated);
                            projectsService.save(project);
                            break;
                        } catch (ProjectAlreadyExistException exception) {
                            view.write(exception.getMessage());
                        }
                    }
                    view.write("Project added. Thank you!");
                }
            } else {
                view.write("Project not added. Try again.");
            }
        } else {
            view.write("Project not added. Try again.");
        }
    }
}
