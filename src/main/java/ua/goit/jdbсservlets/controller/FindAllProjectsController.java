package ua.goit.jdbсservlets.controller;

import ua.goit.jdbсservlets.config.DatabaseManagerConnector;
import ua.goit.jdbсservlets.config.PropertiesConfig;
import ua.goit.jdbсservlets.model.dto.ProjectsDto;
import ua.goit.jdbсservlets.repository.ProjectsRepository;
import ua.goit.jdbсservlets.service.ProjectsService;
import ua.goit.jdbсservlets.service.convert.ProjectsConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/projects/all")
public class FindAllProjectsController extends HttpServlet {
    private ProjectsService projectsService;

    @Override
    public void init() {
        String dbUsername = System.getenv("dbUsername");
        String dbPassword = System.getenv("dbPassword");
        Properties properties = new PropertiesConfig().loadProperties("application.properties");
        DatabaseManagerConnector dbManager = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        ProjectsRepository projectsRepository = new ProjectsRepository(dbManager);
        ProjectsConverter projectsConverter = new ProjectsConverter();
        projectsService = new ProjectsService(projectsRepository, projectsConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProjectsDto> projectsDtoList = projectsService.findAll();
        req.setAttribute("projects", projectsDtoList);
        req.getRequestDispatcher("/view/findAllProjects.jsp").forward(req, resp);
    }
}
