package ua.goit.jdbсservlets.controller;

import ua.goit.jdbсservlets.config.DatabaseManagerConnector;
import ua.goit.jdbсservlets.config.PropertiesConfig;
import ua.goit.jdbсservlets.dto.DevelopersDto;
import ua.goit.jdbсservlets.repository.DevelopersRepository;
import ua.goit.jdbсservlets.service.DevelopersService;
import ua.goit.jdbсservlets.service.convert.DevelopersConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(urlPatterns = "/developers/update")
public class UpdateDeveloperController extends HttpServlet {
    private DevelopersService developersService;

    @Override
    public void init() {
        String dbUsername = System.getenv("dbUsername");
        String dbPassword = System.getenv("dbPassword");
        Properties properties = new PropertiesConfig().loadProperties("application.properties");
        DatabaseManagerConnector dbManager = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        DevelopersRepository developersRepository = new DevelopersRepository(dbManager);
        DevelopersConverter developersConverter = new DevelopersConverter();
        developersService = new DevelopersService(developersRepository, developersConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int developerId = Integer.parseInt(req.getParameter("developerId"));
        DevelopersDto developerDto = developersService.findById(developerId);
        developersService.delete(developerDto);
        req.getRequestDispatcher("/view/deleteDeveloper.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("developerId"));
        String developerName = req.getParameter("developerName");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String different = req.getParameter("different");
        int salary = Integer.parseInt(req.getParameter("salary"));
        DevelopersDto developersDto = new DevelopersDto(id, developerName, age, gender, different, salary);
        DevelopersDto updatedDeveloper = developersService.update(developersDto);
        req.setAttribute("updatedDeveloper", updatedDeveloper);
        req.getRequestDispatcher("/view/updateDeveloper.jsp").forward(req, resp);
    }
}
