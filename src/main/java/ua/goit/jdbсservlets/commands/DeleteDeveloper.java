package ua.goit.jdbсservlets.commands;

import ua.goit.jdbсservlets.dto.DevelopersDto;
import ua.goit.jdbсservlets.service.DevelopersService;


public class DeleteDeveloper {//implements Command {
//    public static final String DELETE_DEVELOPER = "delete_developer";
//    private final View view;
//    private final DevelopersService developersService;
//
//    public DeleteDeveloper(View view, DevelopersService developersService) {
//        this.view = view;
//        this.developersService = developersService;
//    }
//
//    @Override
//    public boolean canExecute(String input) {
//        return input.equals(DELETE_DEVELOPER);
//    }
//
//    @Override
//    public void execute() {
//        view.write("Enter ID by developer: ");
//        int id = Integer.parseInt(view.read());
//        while (true) {
//            try {
//                DevelopersDto developer = developersService.findById(id);
//                developersService.delete(developer);
//                break;
//            } catch (RuntimeException exception) {
//                view.write(exception.getMessage());
//            }
//        }
//        view.write("Developer deleted. Thank you!");
//    }
}
