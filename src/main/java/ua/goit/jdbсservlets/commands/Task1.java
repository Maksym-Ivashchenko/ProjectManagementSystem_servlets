package ua.goit.jdbсservlets.commands;

import ua.goit.jdbсservlets.service.ProjectsService;


public class Task1 {//implements Command {
//    public static final String TASK_1 = "task_1";
//    private final View view;
//    private final ProjectsService projectsService;
//
//    public Task1(View view, ProjectsService projectsService) {
//        this.view = view;
//        this.projectsService = projectsService;
//    }
//
//    @Override
//    public boolean canExecute(String input) {
//        return input.equals(TASK_1);
//    }
//
//    @Override
//    public void execute() {
//        view.write("Enter project name: ");
//        String projectName = view.read();
//        while (true) {
//            try {
//                Integer salary = projectsService.getSalaryOfAllDevelopersFromProject(projectName);
//                System.out.println("Salary of all developers from " + projectName + ": " + salary + "$");
//                break;
//            } catch (RuntimeException exception) {
//                view.write(exception.getMessage());
//            }
//        }
//        view.write("Salary displayed on the screen. Thank you!");
//    }
}
