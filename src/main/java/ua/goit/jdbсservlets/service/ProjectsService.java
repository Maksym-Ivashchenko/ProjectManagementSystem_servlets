package ua.goit.jdbсservlets.service;

import ua.goit.jdbсservlets.dao.ProjectsDao;
import ua.goit.jdbсservlets.dto.ProjectsDto;
import ua.goit.jdbсservlets.repository.ProjectsRepository;
import ua.goit.jdbсservlets.service.convert.ProjectsConverter;

import java.util.List;

public class ProjectsService implements Service<ProjectsDto> {
    private final ProjectsRepository projectsRepository;
    private final ProjectsConverter projectsConverter;

    public ProjectsService(ProjectsRepository projectsRepository, ProjectsConverter projectsConverter) {
        this.projectsRepository = projectsRepository;
        this.projectsConverter = projectsConverter;
    }

    @Override
    public ProjectsDto save(ProjectsDto dto) {
        ProjectsDao savedProject = projectsRepository.save(projectsConverter.to(dto));
        return projectsConverter.from(savedProject);
    }

    @Override
    public ProjectsDto update(ProjectsDto dto) {
        ProjectsDao project = projectsRepository.update(projectsConverter.to(dto));
        return projectsConverter.from(project);
    }

    @Override
    public void delete(ProjectsDto dto) {
        projectsRepository.delete(projectsConverter.to(dto));
    }

    @Override
    public ProjectsDto findById(Integer id) {
        ProjectsDao byId = projectsRepository.findById(id);
        return projectsConverter.from(byId);
    }

    public Integer getSalaryOfAllDevelopersFromProject(String projectName) {
        return projectsRepository.getSalaryOfAllDevelopersFromProject(projectName);
    }

    public List<String> getListOfProjectDevelopers(String projectName) {
        return projectsRepository.getListOfProjectDevelopers(projectName);
    }

    public List<String> getListOfProjectsInTheFormat() {
        return projectsRepository.getListOfProjectsInTheFormat();
    }

    public List<String> getListOfProjectsNames() {
        return projectsRepository.getListOfProjectsNames();
    }

    public int getCountOfColumn(String tableName) {
        return projectsRepository.getCountOfColumn(tableName);
    }
}
