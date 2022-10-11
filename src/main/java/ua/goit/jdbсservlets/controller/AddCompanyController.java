package ua.goit.jdbсservlets.controller;

import ua.goit.jdbсservlets.config.DatabaseManagerConnector;
import ua.goit.jdbсservlets.config.PropertiesConfig;
import ua.goit.jdbсservlets.dto.CompaniesDto;
import ua.goit.jdbсservlets.repository.CompaniesRepository;
import ua.goit.jdbсservlets.service.CompaniesService;
import ua.goit.jdbсservlets.service.convert.CompaniesConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(urlPatterns = "/companies/add")
public class AddCompanyController extends HttpServlet {
    private CompaniesService companiesService;

    @Override
    public void init() {
        String dbUsername = System.getenv("dbUsername");
        String dbPassword = System.getenv("dbPassword");
        Properties properties = new PropertiesConfig().loadProperties("application.properties");
        DatabaseManagerConnector dbManager = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        CompaniesRepository companiesRepository = new CompaniesRepository(dbManager);
        CompaniesConverter companiesConverter = new CompaniesConverter();
        companiesService = new CompaniesService(companiesRepository, companiesConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyName = req.getParameter("companyName");
        String city = req.getParameter("city");
        String email = req.getParameter("email");
        CompaniesDto company = new CompaniesDto(companyName, city, email);
        CompaniesDto savedCompany = companiesService.save(company);
        req.setAttribute("savedCompany", savedCompany);
        req.getRequestDispatcher("/view/addCompany.jsp").forward(req, resp);
    }
}
