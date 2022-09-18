package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.CustomersDto;
import ua.goit.jdbс.service.CustomersService;
import ua.goit.jdbс.view.View;

public class DeleteCustomer implements Command {
    public static final String DELETE_CUSTOMER = "delete_customer";
    private final View view;
    private final CustomersService customersService;

    public DeleteCustomer(View view, CustomersService customersService) {
        this.view = view;
        this.customersService = customersService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(DELETE_CUSTOMER);
    }

    @Override
    public void execute() {
        view.write("Enter ID by customer: ");
        int id = Integer.parseInt(view.read());
        while (true) {
            try {
                CustomersDto customer = customersService.findById(id);
                customersService.delete(customer);
                break;
            } catch (RuntimeException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Customer deleted. Thank you!");
    }
}
