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
import java.util.Properties;

@WebServlet(urlPatterns = "/skills")
public class SkillController extends HttpServlet {
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
        int skillId = Integer.parseInt(req.getParameter("skillId"));
        SkillsDto skillById = skillsService.findById(skillId);
        req.setAttribute("skill", skillById);
        req.getRequestDispatcher("/view/findSkill.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String branch = req.getParameter("branch");
        String skillLevel = req.getParameter("skillLevel");
        SkillsDto skillsDto = new SkillsDto(branch, skillLevel);
        SkillsDto savedSkill = skillsService.save(skillsDto);
        req.setAttribute("savedSkill", savedSkill);
        req.getRequestDispatcher("/view/addSkill.jsp").forward(req, resp);
    }
}
