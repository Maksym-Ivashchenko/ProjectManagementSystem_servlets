package ua.goit.jdbсservlets.commands;

import ua.goit.jdbсservlets.service.ProjectsService;


import java.util.List;

public class Task5 {//implements Command {
//    public static final String TASK_5 = "task_5";
//    private final View view;
//    private final ProjectsService projectsService;
//
//    public Task5(View view, ProjectsService projectsService) {
//        this.view = view;
//        this.projectsService = projectsService;
//    }
//
//    @Override
//    public boolean canExecute(String input) {
//        return input.equals(TASK_5);
//    }
//
//    @Override
//    public void execute() {
//        while (true) {
//            try {
//                List<String> listOfProjectsInTheFormat = projectsService.getListOfProjectsInTheFormat();
//                System.out.println("List of projects in the format: " + listOfProjectsInTheFormat);
//                break;
//            } catch (RuntimeException exception) {
//                view.write(exception.getMessage());
//            }
//        }
//        view.write("Projects displayed on the screen. Thank you!");
//    }
}
