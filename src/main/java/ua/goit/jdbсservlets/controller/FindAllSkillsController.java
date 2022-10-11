package ua.goit.jdbсservlets.controller;

import ua.goit.jdbсservlets.config.DatabaseManagerConnector;
import ua.goit.jdbсservlets.config.PropertiesConfig;
import ua.goit.jdbсservlets.dto.SkillsDto;
import ua.goit.jdbсservlets.repository.SkillsRepository;
import ua.goit.jdbсservlets.service.SkillsService;
import ua.goit.jdbсservlets.service.convert.SkillsConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/skills/all")
public class FindAllSkillsController extends HttpServlet {
    private SkillsService skillsService;

    @Override
    public void init() {
        String dbUsername = System.getenv("dbUsername");
        String dbPassword = System.getenv("dbPassword");
        Properties properties = new PropertiesConfig().loadProperties("application.properties");
        DatabaseManagerConnector dbManager = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        SkillsRepository skillsRepository = new SkillsRepository(dbManager);
        SkillsConverter skillsConverter = new SkillsConverter();
        skillsService = new SkillsService(skillsRepository, skillsConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SkillsDto> skillsDtoList = skillsService.findAll();
        req.setAttribute("skills", skillsDtoList);
        req.getRequestDispatcher("/view/findAllSkills.jsp").forward(req, resp);
    }
}
