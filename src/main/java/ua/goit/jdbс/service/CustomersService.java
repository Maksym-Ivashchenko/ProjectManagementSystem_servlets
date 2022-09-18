package ua.goit.jdbс.service;

import ua.goit.jdbс.dao.CustomersDao;
import ua.goit.jdbс.dto.CustomersDto;
import ua.goit.jdbс.repository.CustomersRepository;
import ua.goit.jdbс.service.convert.CustomersConverter;

public class CustomersService implements Service<CustomersDto> {
    private final CustomersRepository customersRepository;
    private final CustomersConverter customersConverter;

    public CustomersService(CustomersRepository customersRepository, CustomersConverter customersConverter) {
        this.customersRepository = customersRepository;
        this.customersConverter = customersConverter;
    }

    @Override
    public CustomersDto save(CustomersDto entity) {
        CustomersDao savedCustomer = customersRepository.save(customersConverter.to(entity));
        return customersConverter.from(savedCustomer);
    }

    @Override
    public CustomersDto update(CustomersDto entity) {
        CustomersDao updatedCustomer = customersRepository.update(customersConverter.to(entity));
        return customersConverter.from(updatedCustomer);
    }

    @Override
    public void delete(CustomersDto entity) {
        customersRepository.delete(customersConverter.to(entity));
    }

    @Override
    public CustomersDto findById(Integer id) {
        CustomersDao byId = customersRepository.findById(id);
        return customersConverter.from(byId);
    }
}
