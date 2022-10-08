package ua.goit.jdbсservlets.commands;

import ua.goit.jdbсservlets.service.DevelopersService;


import java.util.List;

public class Task4 {//implements Command {
//    public static final String TASK_4 = "task_4";
//    private final View view;
//    private final DevelopersService developersService;
//
//    public Task4(View view, DevelopersService developersService) {
//        this.view = view;
//        this.developersService = developersService;
//    }
//
//    @Override
//    public boolean canExecute(String input) {
//        return input.equals(TASK_4);
//    }
//
//    @Override
//    public void execute() {
//        view.write("Enter developer skill level (Junior, Middle or Senior): ");
//        String skillLevel = view.read();
//        while (true) {
//            try {
//                List<String> list = developersService.getListOfAllDevelopersBySkillLevel(skillLevel);
//                System.out.println(list);
//                break;
//            } catch (RuntimeException exception) {
//                view.write(exception.getMessage());
//            }
//        }
//        view.write("Developers found. Thank you!");
//    }
}
