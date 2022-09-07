package ua.goit.jdbс.service.convert;

import ua.goit.jdbс.dao.CustomersDao;
import ua.goit.jdbс.dto.CustomersDto;

public class CustomersConverter implements Converter<CustomersDto, CustomersDao> {
    @Override
    public CustomersDto from(CustomersDao entity) {
        CustomersDto dto = new CustomersDto();
        dto.setId(entity.getId());
        dto.setCustomerName(entity.getCustomerName());
        dto.setCountry(entity.getCountry());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    @Override
    public CustomersDao to(CustomersDto entity) {
        CustomersDao dao = new CustomersDao();
        dao.setId(entity.getId());
        dao.setCustomerName(entity.getCustomerName());
        dao.setCountry(entity.getCountry());
        dao.setEmail(entity.getEmail());
        return dao;
    }
}
