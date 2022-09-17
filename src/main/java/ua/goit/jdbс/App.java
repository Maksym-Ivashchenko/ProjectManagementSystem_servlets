package ua.goit.jdbс;


import ua.goit.jdbс.commands.*;
import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.config.PropertiesConfig;
import ua.goit.jdbс.controller.Controller;
import ua.goit.jdbс.repository.DevelopersRepository;
import ua.goit.jdbс.repository.ProjectsRepository;
import ua.goit.jdbс.service.DevelopersService;
import ua.goit.jdbс.service.convert.DevelopersConverter;
import ua.goit.jdbс.view.Console;
import ua.goit.jdbс.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String dbUsername = System.getenv("dbusername");
        String dbPassword = System.getenv("dbpassword");
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        Properties properties = propertiesConfig.loadProperties("application.properties");

        DatabaseManagerConnector dbManager = new DatabaseManagerConnector(properties, dbUsername,dbPassword);
        Scanner scanner = new Scanner(System.in);
        View view = new Console(scanner);

        DevelopersRepository developersRepository = new DevelopersRepository(dbManager);
        DevelopersConverter developersConverter = new DevelopersConverter();
        DevelopersService developersService = new DevelopersService(developersRepository, developersConverter);

//        ProjectsRepository projectsRepository = new ProjectsRepository(dbManager);

        List<Command> commands = new ArrayList<>();
        commands.add(new Help(view));
        commands.add(new Exit(view));
        commands.add(new AddDeveloper(view, developersService));
        commands.add(new UpdateDeveloper(view, developersService));
        commands.add(new DeleteDeveloper(view, developersService));
        commands.add(new FindDeveloper(view, developersService));

        commands.add(new Task3(view, developersService));
        commands.add(new Task4(view, developersService));

        Controller controller = new Controller(view, commands);

        controller.run();


//        String projectName = "Project_3";
//        String skillBranch = "Java";
//        String skillLevel = "Middle";
//
//
//        Integer project = projectsRepository.getSalaryOfAllDevelopersFromProject(projectName);
//        System.out.println("Salary of all developers from " + projectName + ": " + project + "$");
//
//        List<String> projectDevelopers = projectsRepository.getListOfProjectDevelopers(projectName);
//        System.out.println("Developers name from " + projectName + " " + projectDevelopers);
//
//        List<String> developersByBranch = developersRepository.getListOfAllDevelopersByBranch(skillBranch);
//        System.out.println("Developers by " + skillBranch + " " + developersByBranch);
//
//        List<String> developersBySkillLevel = developersRepository.getListOfAllDevelopersBySkillLevel(skillLevel);
//        System.out.println("Developers by " + skillLevel + " " + developersBySkillLevel);
//
//        List<String> listOfProjectsInTheFormat = projectsRepository.getListOfProjectsInTheFormat();
//        System.out.println(listOfProjectsInTheFormat);
//
//
//        DevelopersDao developer = new DevelopersDao();
//        developer.setId(11);
//        developer.setDeveloperName("Maksim");
//        developer.setAge(36);
//        developer.setGender("men");
//        developer.setDifferent("maksim@mail.com");
//        developer.setSalary(3000);
//
//        developersRepository.save(developer);
//        DevelopersDao savedDeveloper = developersRepository.findById(11);
//        System.out.println(savedDeveloper);
//        developersRepository.update(developer);
//        developersRepository.delete(developer);
//        List<DevelopersDao> all = developersRepository.findAll();
//        System.out.println(all);
    }
}
