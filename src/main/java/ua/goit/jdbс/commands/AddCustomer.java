package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.CustomersDto;
import ua.goit.jdbс.exceptions.CustomerAlreadyExistException;
import ua.goit.jdbс.service.CustomersService;
import ua.goit.jdbс.view.View;

public class AddCustomer implements Command {
    public static final String ADD_CUSTOMER = "add_customer";
    private final View view;
    private final CustomersService customersService;

    public AddCustomer(View view, CustomersService customersService) {
        this.view = view;
        this.customersService = customersService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(ADD_CUSTOMER);
    }

    @Override
    public void execute() {
        view.write("Enter customer name: ");
        String customerName = view.read();
        view.write("Enter country, customer location: ");
        String country = view.read();
        view.write("Enter customer's email: ");
        String email = view.read();
        while (true) {
            try {
                CustomersDto customer = new CustomersDto(customerName, country, email);
                customersService.save(customer);
                break;
            } catch (CustomerAlreadyExistException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Customer added. Thank you!");
    }
}
