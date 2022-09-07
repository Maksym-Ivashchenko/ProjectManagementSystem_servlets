package ua.goit.jdbс;


import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.config.PropertiesConfig;
import ua.goit.jdbс.dao.DevelopersDao;
import ua.goit.jdbс.repository.DevelopersRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class App {

    public static void main(String[] args) {
        String dbUsername = System.getenv("dbusername");
        String dbPassword = System.getenv("dbpassword");
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        Properties properties = propertiesConfig.loadProperties("application.properties");

        DatabaseManagerConnector dbManager = new DatabaseManagerConnector(properties, dbUsername,dbPassword);

        DevelopersRepository developersRepository = new DevelopersRepository(dbManager);
        DevelopersDao developer = new DevelopersDao();
        developer.setId(11);
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
        List<DevelopersDao> all = developersRepository.findAll();
        System.out.println(all);
    }
}
