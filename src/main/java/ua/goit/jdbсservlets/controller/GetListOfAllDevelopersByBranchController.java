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
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/developers/branch")
public class GetListOfAllDevelopersByBranchController extends HttpServlet {
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
        String developerBranch = req.getParameter("developerBranch");
        List<DevelopersDto> developersByBranch = developersService.getListOfAllDevelopersByBranch(developerBranch);
        req.setAttribute("developers", developersByBranch);
        req.getRequestDispatcher("/view/getListOfAllDevelopersByBranch.jsp").forward(req, resp);
    }
}
