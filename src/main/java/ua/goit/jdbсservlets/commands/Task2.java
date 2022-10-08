package ua.goit.jdbсservlets.commands;

import ua.goit.jdbсservlets.service.ProjectsService;


import java.util.List;

public class Task2 {//implements Command {
//    public static final String TASK_2 = "task_2";
//    private final View view;
//    private final ProjectsService projectsService;
//
//    public Task2(View view, ProjectsService projectsService) {
//        this.view = view;
//        this.projectsService = projectsService;
//    }
//
//    @Override
//    public boolean canExecute(String input) {
//        return input.equals(TASK_2);
//    }
//
//    @Override
//    public void execute() {
//        System.out.println(projectsService.getListOfProjectsNames());
//        view.write("Enter project name: ");
//        String projectName = view.read();
//        while (true) {
//            try {
//                List<String> projectDevelopers = projectsService.getListOfProjectDevelopers(projectName);
//                System.out.println("Developers name from " + projectName + " " + projectDevelopers);
//                break;
//            } catch (RuntimeException exception) {
//                view.write(exception.getMessage());
//            }
//        }
//        view.write("Developers displayed on the screen. Thank you!");
//    }
}
