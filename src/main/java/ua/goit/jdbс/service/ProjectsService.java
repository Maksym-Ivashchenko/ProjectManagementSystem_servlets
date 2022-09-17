package ua.goit.jdbс.service;

import ua.goit.jdbс.dao.ProjectsDao;
import ua.goit.jdbс.dto.ProjectsDto;
import ua.goit.jdbс.repository.ProjectsRepository;
import ua.goit.jdbс.service.convert.ProjectsConverter;

public class ProjectsService {
    private ProjectsRepository projectsRepository;
    private ProjectsConverter projectsConverter;

    public ProjectsService(ProjectsRepository projectsRepository, ProjectsConverter projectsConverter) {
        this.projectsRepository = projectsRepository;
        this.projectsConverter = projectsConverter;
    }

    public ProjectsDto save(ProjectsDto dto) {
        ProjectsDao savedProject = projectsRepository.save(projectsConverter.to(dto));
        return projectsConverter.from(savedProject);
    }
}
