package ua.goit.jdbс.controller;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.config.PropertiesConfig;
import ua.goit.jdbс.dto.DevelopersDto;
import ua.goit.jdbс.repository.DevelopersRepository;
import ua.goit.jdbс.service.DevelopersService;
import ua.goit.jdbс.service.convert.DevelopersConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(urlPatterns = "/developers")
public class FindDeveloperController extends HttpServlet {
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
        int developerId = Integer.parseInt(req.getParameter("id"));
        DevelopersDto developer = developersService.findById(developerId);
        req.setAttribute("developer", developer);
        req.getRequestDispatcher("/jsp/findDeveloper.jsp").forward(req, resp);
    }
}
