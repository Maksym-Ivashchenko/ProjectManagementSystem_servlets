package ua.goit.jdbсservlets.controller;

import ua.goit.jdbсservlets.config.DatabaseManagerConnector;
import ua.goit.jdbсservlets.config.PropertiesConfig;
import ua.goit.jdbсservlets.dto.CustomersDto;
import ua.goit.jdbсservlets.repository.CustomersRepository;
import ua.goit.jdbсservlets.service.CustomersService;
import ua.goit.jdbсservlets.service.convert.CustomersConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(urlPatterns = "/customers")
public class FindCustomerController extends HttpServlet {
    private CustomersService customersService;

    @Override
    public void init() {
        String dbUsername = System.getenv("dbUsername");
        String dbPassword = System.getenv("dbPassword");
        Properties properties = new PropertiesConfig().loadProperties("application.properties");
        DatabaseManagerConnector dbManager = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        CustomersRepository customersRepository = new CustomersRepository(dbManager);
        CustomersConverter customersConverter = new CustomersConverter();
        customersService = new CustomersService(customersRepository, customersConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        CustomersDto customerById = customersService.findById(customerId);
        req.setAttribute("customer", customerById);
        req.getRequestDispatcher("/view/findCustomer.jsp").forward(req, resp);
    }
}
