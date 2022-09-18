package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.CustomersDto;
import ua.goit.jdbс.service.CustomersService;
import ua.goit.jdbс.view.View;

public class FindCustomer implements Command {
    public static final String FIND_CUSTOMER = "find_customer";
    private final View view;
    private final CustomersService customersService;

    public FindCustomer(View view, CustomersService customersService) {
        this.view = view;
        this.customersService = customersService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(FIND_CUSTOMER);
    }

    @Override
    public void execute() {
        view.write("Enter ID by customer: ");
        int id = Integer.parseInt(view.read());
        while (true) {
            try {
                CustomersDto customer = customersService.findById(id);
                System.out.println(customer);
                break;
            } catch (RuntimeException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Customer found. Thank you!");
    }
}
