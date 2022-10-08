package ua.goit.jdbсservlets.service;

import ua.goit.jdbсservlets.dao.DevelopersDao;
import ua.goit.jdbсservlets.dto.DevelopersDto;
import ua.goit.jdbсservlets.exceptions.DeveloperAlreadyExistException;
import ua.goit.jdbсservlets.repository.DevelopersRepository;
import ua.goit.jdbсservlets.service.convert.DevelopersConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevelopersService implements Service<DevelopersDto> {
    private final DevelopersRepository developersRepository;
    private final DevelopersConverter developersConverter;

    public DevelopersService(DevelopersRepository developersRepository, DevelopersConverter developersConverter) {
        this.developersRepository = developersRepository;
        this.developersConverter = developersConverter;
    }

    @Override
    public DevelopersDto save(DevelopersDto dto) {
        DevelopersDao savedDeveloper = developersRepository.save(developersConverter.to(dto));
        DevelopersDto developersDto = developersConverter.from(savedDeveloper);
        validateDeveloper(dto, developersDto);
        return developersDto;
    }

    @Override
    public DevelopersDto update(DevelopersDto dto) {
        DevelopersDao dao = developersRepository.update(developersConverter.to(dto));
        return developersConverter.from(dao);
    }

    @Override
    public void delete(DevelopersDto dto) {
        developersRepository.delete(developersConverter.to(dto));
    }

    @Override
    public DevelopersDto findById(Integer id) {
        DevelopersDao byId = developersRepository.findById(id);
        return developersConverter.from(byId);
    }

    public List<DevelopersDto> findAll() {
        List<DevelopersDto> developersDtoList = new ArrayList<>();
        List<DevelopersDao> developersDaoList = developersRepository.findAll();
        for (DevelopersDao dao : developersDaoList) {
            developersDtoList.add(developersConverter.from(dao));
        }
        return developersDtoList;
    }

    public List<String> getListOfAllDevelopersByBranch(String branch) {
        return developersRepository.getListOfAllDevelopersByBranch(branch);
    }

    public List<String> getListOfAllDevelopersBySkillLevel(String skillLevel) {
        return developersRepository.getListOfAllDevelopersBySkillLevel(skillLevel);
    }

    public int getCountOfColumn(String tableName) {
        return developersRepository.getCountOfColumn(tableName);
    }

    private void validateDeveloper(DevelopersDto savedDeveloper, DevelopersDto newDeveloper) {
        if(!savedDeveloper.getDeveloperName().equals(newDeveloper.getDeveloperName()) ||
                !savedDeveloper.getAge().equals(newDeveloper.getAge())) {
            throw new DeveloperAlreadyExistException(String.format("Developer with name %s already exist with different " +
                    "age %s", savedDeveloper.getDeveloperName(), savedDeveloper.getAge()));
        }
    }
}
