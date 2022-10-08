package ua.goit.jdbсservlets.commands;

import ua.goit.jdbсservlets.dto.DevelopersDto;
import ua.goit.jdbсservlets.service.DevelopersService;


public class FindDeveloper {//implements Command {
//    public static final String FIND_DEVELOPER = "find_developer";
//    private final View view;
//    private final DevelopersService developersService;
//
//    public FindDeveloper(View view, DevelopersService developersService) {
//        this.view = view;
//        this.developersService = developersService;
//    }
//
//    @Override
//    public boolean canExecute(String input) {
//        return input.equals(FIND_DEVELOPER);
//    }
//
//    @Override
//    public void execute() {
//        view.write("Enter ID by developer: ");
//        int id = Integer.parseInt(view.read());
//        while (true) {
//            try {
//                DevelopersDto developer = developersService.findById(id);
//                System.out.println(developer);
//                break;
//            } catch (RuntimeException exception) {
//                view.write(exception.getMessage());
//            }
//        }
//        view.write("Developer found. Thank you!");
//    }
}
