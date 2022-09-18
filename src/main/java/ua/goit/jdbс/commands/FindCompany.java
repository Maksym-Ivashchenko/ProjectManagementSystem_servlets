package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.CompaniesDto;
import ua.goit.jdbс.service.CompaniesService;
import ua.goit.jdbс.view.View;

public class FindCompany implements Command {
    public static final String FIND_COMPANY = "find_company";
    private final View view;
    private final CompaniesService companiesService;

    public FindCompany(View view, CompaniesService companiesService) {
        this.view = view;
        this.companiesService = companiesService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(FIND_COMPANY);
    }

    @Override
    public void execute() {
        view.write("Enter ID by company: ");
        int id = Integer.parseInt(view.read());
        while (true) {
            try {
                CompaniesDto company = companiesService.findById(id);
                System.out.println(company);
                break;
            } catch (RuntimeException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Company found. Thank you!");
    }
}
