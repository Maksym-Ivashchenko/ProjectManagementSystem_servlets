package ua.goit.jdbсservlets.commands;

import ua.goit.jdbсservlets.dto.DevelopersDto;
import ua.goit.jdbсservlets.exceptions.DeveloperAlreadyExistException;
import ua.goit.jdbсservlets.repository.DevelopersRepository;
import ua.goit.jdbсservlets.service.DevelopersService;


public class AddDeveloper {//implements Command {
//    public static final String ADD_DEVELOPER = "add_developer";
//    private final View view;
//    private final DevelopersService developersService;
//
//    public AddDeveloper(View view, DevelopersService developersService) {
//        this.view = view;
//        this.developersService = developersService;
//    }
//
//    @Override
//    public boolean canExecute(String input) {
//        return input.equals(ADD_DEVELOPER);
//    }
//
//    @Override
//    public void execute() {
//        view.write("Enter developer name, age, gender, email and salary separated by a '/': ");
//        String[] developerColumns = view.read().split("/");
//        String name;
//        int age = -1;
//        String gender;
//        String different;
//        int salary = -1;
//        if (developerColumns.length == developersService.getCountOfColumn(DevelopersRepository.TABLE_NAME) - 1) {
//            for (int i = 0; i <= developerColumns.length - 1; i++) {
//                String s = developerColumns[i].replace(",", "").strip();
//                developerColumns[i] = s;
//            }
//            name = developerColumns[0];
//            try {
//                age = Integer.parseInt(developerColumns[1]);
//            } catch (NumberFormatException e) {
//                view.write("Invalid value. Use digits");
//            }
//            if (age == -1) {
//                view.write("Developer not added. Try again.");
//            } else if (age > 0) {
//                gender = developerColumns[2];
//                different = developerColumns[3];
//                try {
//                    salary = Integer.parseInt(developerColumns[4]);
//                } catch (NumberFormatException e) {
//                    view.write("Invalid value. Use digits");
//                }
//                if (salary == -1) {
//                    view.write("Developer not added. Try again.");
//                } else {
//                    while (true) {
//                        try {
//                            DevelopersDto developer = new DevelopersDto(name, age, gender, different, salary);
//                            developersService.save(developer);
//                            break;
//                        } catch (DeveloperAlreadyExistException exception) {
//                            view.write(exception.getMessage());
//                        }
//                    }
//                    view.write("Developer added. Thank you!");
//                }
//            } else {
//                view.write("Developer not added. Try again.");
//            }
//        } else {view.write("Developer not added. Try again.");}
//    }
}