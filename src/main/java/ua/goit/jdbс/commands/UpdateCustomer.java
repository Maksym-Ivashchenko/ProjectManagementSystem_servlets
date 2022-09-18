package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.CustomersDto;
import ua.goit.jdbс.exceptions.CustomerAlreadyExistException;
import ua.goit.jdbс.service.CustomersService;
import ua.goit.jdbс.view.View;

public class UpdateCustomer implements Command {
    public static final String UPDATE_CUSTOMER = "update_customer";
    private final View view;
    private final CustomersService customersService;

    public UpdateCustomer(View view, CustomersService customersService) {
        this.view = view;
        this.customersService = customersService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(UPDATE_CUSTOMER);
    }

    @Override
    public void execute() {
        view.write("Enter ID by customer: ");
        int id = Integer.parseInt(view.read());
        view.write("Enter customer name: ");
        String customerName = view.read();
        view.write("Enter country, customer location: ");
        String country = view.read();
        view.write("Enter customer's email: ");
        String email = view.read();
        while (true) {
            try {
                CustomersDto customer = new CustomersDto(id, customerName, country, email);
                customersService.update(customer);
                break;
            } catch (CustomerAlreadyExistException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Customer updated. Thank you!");
    }
}
