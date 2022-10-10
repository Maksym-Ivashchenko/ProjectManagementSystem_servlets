package ua.goit.jdbсservlets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/developers/level/form")
public class GetListOfAllDevelopersBySkillLevelFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/getListOfAllDevelopersBySkillLevelForm.jsp").forward(req, resp);
    }
}
