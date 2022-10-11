package ua.goit.jdbсservlets.service;

import ua.goit.jdbсservlets.dao.CustomersDao;
import ua.goit.jdbсservlets.dto.CustomersDto;
import ua.goit.jdbсservlets.repository.CustomersRepository;
import ua.goit.jdbсservlets.service.convert.CustomersConverter;

import java.util.ArrayList;
import java.util.List;

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

    public List<CustomersDto> findAll() {
        List<CustomersDto> customersDtoList = new ArrayList<>();
        List<CustomersDao> customersDaoList = customersRepository.findAll();
        for (CustomersDao dao: customersDaoList) {
            customersDtoList.add(customersConverter.from(dao));
        }
        return customersDtoList;
    }
}
