package ua.goit.jdbс.service;

import ua.goit.jdbс.dao.CompaniesDao;
import ua.goit.jdbс.dto.CompaniesDto;
import ua.goit.jdbс.repository.CompaniesRepository;
import ua.goit.jdbс.service.convert.CompaniesConverter;

public class CompaniesService implements Service<CompaniesDto> {
    private final CompaniesRepository companiesRepository;
    private final CompaniesConverter companiesConverter;

    public CompaniesService(CompaniesRepository companiesRepository, CompaniesConverter companiesConverter) {
        this.companiesRepository = companiesRepository;
        this.companiesConverter = companiesConverter;
    }

    @Override
    public CompaniesDto save(CompaniesDto entity) {
        CompaniesDao savedCompany = companiesRepository.save(companiesConverter.to(entity));
        return companiesConverter.from(savedCompany);
    }

    @Override
    public CompaniesDto update(CompaniesDto entity) {
        CompaniesDao updatedCompany = companiesRepository.update(companiesConverter.to(entity));
        return companiesConverter.from(updatedCompany);
    }

    @Override
    public void delete(CompaniesDto entity) {
        companiesRepository.delete(companiesConverter.to(entity));
    }

    @Override
    public CompaniesDto findById(Integer id) {
        CompaniesDao byId = companiesRepository.findById(id);
        return companiesConverter.from(byId);
    }

    public Integer getCountOfColumn(String tableName) {
        return companiesRepository.getCountOfColumn(tableName);
    }
}
