package ua.goit.jdbсservlets.commands;

import ua.goit.jdbсservlets.service.DevelopersService;


import java.util.List;

public class Task3 {//implements Command {
//    public static final String TASK_3 = "task_3";
//    private final View view;
//    private final DevelopersService developersService;
//
//    public Task3(View view, DevelopersService developersService) {
//        this.view = view;
//        this.developersService = developersService;
//    }
//
//    @Override
//    public boolean canExecute(String input) {
//        return input.equals(TASK_3);
//    }
//
//    @Override
//    public void execute() {
//        view.write("Enter developer branch (Java, C++, C# or JS): ");
//        String branch = view.read();
//        while (true) {
//            try {
//                List<String> list = developersService.getListOfAllDevelopersByBranch(branch);
//                System.out.println(list);
//                break;
//            } catch (RuntimeException exception) {
//                view.write(exception.getMessage());
//            }
//        }
//        view.write("Developers found. Thank you!");
//    }
}
