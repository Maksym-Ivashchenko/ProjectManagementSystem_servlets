package ua.goit.jdbс.service;

import ua.goit.jdbс.dao.DevelopersDao;
import ua.goit.jdbс.dto.DevelopersDto;
import ua.goit.jdbс.exceptions.DeveloperAlreadyExistException;
import ua.goit.jdbс.repository.DevelopersRepository;
import ua.goit.jdbс.service.convert.DevelopersConverter;

public class DevelopersService {
    private DevelopersRepository developersRepository;
    private DevelopersConverter developersConverter;

    public DevelopersService(DevelopersRepository developersRepository, DevelopersConverter developersConverter) {
        this.developersRepository = developersRepository;
        this.developersConverter = developersConverter;
    }

    public DevelopersDto save(DevelopersDto dto) {
        DevelopersDao savedDeveloper = developersRepository.save(developersConverter.to(dto));
        return developersConverter.from(savedDeveloper);
    }

    public DevelopersDto findById(Integer id) {
        DevelopersDao byId = developersRepository.findById(id);
        return developersConverter.from(byId);
    }

    public void validateDeveloper(DevelopersDto savedDeveloper, DevelopersDto newDeveloper) {
        if(!savedDeveloper.getDeveloperName().equals(newDeveloper.getDeveloperName()) ||
                !savedDeveloper.getAge().equals(newDeveloper.getAge())) {
            throw new DeveloperAlreadyExistException(String.format("Developer with name %s already exist with different " +
                    "age %s", savedDeveloper.getDeveloperName(), savedDeveloper.getAge()));
        }
    }
}
