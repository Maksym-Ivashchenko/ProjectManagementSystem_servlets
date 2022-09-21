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
        view.write("Enter customer name, country and email separated by a '/': ");
        String[] customerColumns = view.read().split("/");
        String customerName = null;
        String country = null;
        String email = null;
        if (customerColumns.length == customersService.getCountOfColumn() - 1) {
            for (int i = 0; i <= customerColumns.length - 1; i++) {
                String s = customerColumns[i].replace(",", "").strip();
                customerColumns[i] = s;
                switch (i) {
                    case 0 -> customerName = customerColumns[i];
                    case 1 -> country = customerColumns[i];
                    case 2 -> email = customerColumns[i];
                }
            }
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
        } else {
            view.write("Customer not added. Try again.");
        }
    }
}
