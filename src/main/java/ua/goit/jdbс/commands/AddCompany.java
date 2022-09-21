package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.CompaniesDto;
import ua.goit.jdbс.exceptions.CompanyAlreadyExistException;
import ua.goit.jdbс.service.CompaniesService;
import ua.goit.jdbс.view.View;

public class AddCompany implements Command {
    public static final String ADD_COMPANY = "add_company";
    private final View view;
    private final CompaniesService companiesService;

    public AddCompany(View view, CompaniesService companiesService) {
        this.view = view;
        this.companiesService = companiesService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(ADD_COMPANY);
    }

    @Override
    public void execute() {
        view.write("Enter company name, city and email separated by a '/': ");
        String[] companyColumns = view.read().split("/");
        String companyName = null;
        String city = null;
        String email = null;
        if (companyColumns.length == companiesService.getCountOfColumn() - 1) {
            for (int i = 0; i <= companyColumns.length - 1; i++) {
                String s = companyColumns[i].replace(",", "").strip();
                companyColumns[i] = s;
                switch (i) {
                    case 0 -> companyName = companyColumns[i];
                    case 1 -> city = companyColumns[i];
                    case 2 -> email = companyColumns[i];
                }
            }
            while (true) {
                try {
                    CompaniesDto company = new CompaniesDto(companyName, city, email);
                    companiesService.save(company);
                    break;
                } catch (CompanyAlreadyExistException exception) {
                    view.write(exception.getMessage());
                }
            }
            view.write("Company added. Thank you!");
        } else {
            view.write("Company not added. Try again.");
        }
    }
}
