package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.CompaniesDto;
import ua.goit.jdbс.exceptions.CompanyAlreadyExistException;
import ua.goit.jdbс.service.CompaniesService;
import ua.goit.jdbс.view.View;

public class UpdateCompany implements Command {
    public static final String UPDATE_COMPANY = "update_company";
    private final View view;
    private final CompaniesService companiesService;

    public UpdateCompany(View view, CompaniesService companiesService) {
        this.view = view;
        this.companiesService = companiesService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(UPDATE_COMPANY);
    }

    @Override
    public void execute() {
        view.write("Enter ID by company: ");
        int id = Integer.parseInt(view.read());
        view.write("Enter company name: ");
        String companyName = view.read();
        view.write("Enter city, company location: ");
        String city = view.read();
        view.write("Enter email of company: ");
        String email = view.read();
        while (true) {
            try {
                CompaniesDto company = new CompaniesDto(id, companyName, city, email);
                companiesService.update(company);
                break;
            } catch (CompanyAlreadyExistException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Company updated. Thank you!");
    }
}
