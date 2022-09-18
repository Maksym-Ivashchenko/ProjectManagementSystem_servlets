package ua.goit.jdbс;


import ua.goit.jdbс.commands.*;
import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.config.PropertiesConfig;
import ua.goit.jdbс.controller.Controller;
import ua.goit.jdbс.repository.*;
import ua.goit.jdbс.service.*;
import ua.goit.jdbс.service.convert.*;
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

        DatabaseManagerConnector dbManager = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        Scanner scanner = new Scanner(System.in);
        View view = new Console(scanner);

        DevelopersRepository developersRepository = new DevelopersRepository(dbManager);
        DevelopersConverter developersConverter = new DevelopersConverter();
        DevelopersService developersService = new DevelopersService(developersRepository, developersConverter);
        ProjectsRepository projectsRepository = new ProjectsRepository(dbManager);
        ProjectsConverter projectsConverter = new ProjectsConverter();
        ProjectsService projectsService = new ProjectsService(projectsRepository, projectsConverter);
        CompaniesRepository companiesRepository = new CompaniesRepository(dbManager);
        CompaniesConverter companiesConverter = new CompaniesConverter();
        CompaniesService companiesService = new CompaniesService(companiesRepository, companiesConverter);
        CustomersRepository customersRepository = new CustomersRepository(dbManager);
        CustomersConverter customersConverter = new CustomersConverter();
        CustomersService customersService = new CustomersService(customersRepository, customersConverter);
        SkillsRepository skillsRepository = new SkillsRepository(dbManager);
        SkillsConverter skillsConverter = new SkillsConverter();
        SkillsService skillsService = new SkillsService(skillsRepository, skillsConverter);

        List<Command> commands = new ArrayList<>();
        commands.add(new Help(view));
        commands.add(new Exit(view));
        commands.add(new AddDeveloper(view, developersService));
        commands.add(new UpdateDeveloper(view, developersService));
        commands.add(new DeleteDeveloper(view, developersService));
        commands.add(new FindDeveloper(view, developersService));
        commands.add(new AddProject(view, projectsService));
        commands.add(new UpdateProject(view, projectsService));
        commands.add(new DeleteProject(view, projectsService));
        commands.add(new FindProject(view, projectsService));
        commands.add(new AddCompany(view, companiesService));
        commands.add(new UpdateCompany(view, companiesService));
        commands.add(new DeleteCompany(view, companiesService));
        commands.add(new FindCompany(view, companiesService));
        commands.add(new AddCustomer(view, customersService));
        commands.add(new UpdateCustomer(view, customersService));
        commands.add(new DeleteCustomer(view, customersService));
        commands.add(new FindCustomer(view, customersService));
        commands.add(new AddSkill(view, skillsService));
        commands.add(new UpdateSkill(view, skillsService));
        commands.add(new DeleteSkill(view, skillsService));
        commands.add(new FindSkill(view, skillsService));
        commands.add(new Task1(view, projectsService));
        commands.add(new Task2(view, projectsService));
        commands.add(new Task3(view, developersService));
        commands.add(new Task4(view, developersService));
        commands.add(new Task5(view, projectsService));

        Controller controller = new Controller(view, commands);

        controller.run();

    }
}
