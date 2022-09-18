package ua.goit.jdbс.service;

import ua.goit.jdbс.dao.SkillsDao;
import ua.goit.jdbс.dto.SkillsDto;
import ua.goit.jdbс.repository.SkillsRepository;
import ua.goit.jdbс.service.convert.SkillsConverter;

public class SkillsService implements Service<SkillsDto> {
    private final SkillsRepository skillsRepository;
    private final SkillsConverter skillsConverter;

    public SkillsService(SkillsRepository skillsRepository, SkillsConverter skillsConverter) {
        this.skillsRepository = skillsRepository;
        this.skillsConverter = skillsConverter;
    }

    @Override
    public SkillsDto save(SkillsDto entity) {
        SkillsDao savedSkill = skillsRepository.save(skillsConverter.to(entity));
        return skillsConverter.from(savedSkill);
    }

    @Override
    public SkillsDto update(SkillsDto entity) {
        SkillsDao updatedSkill = skillsRepository.update(skillsConverter.to(entity));
        return skillsConverter.from(updatedSkill);
    }

    @Override
    public void delete(SkillsDto entity) {
        skillsRepository.delete(skillsConverter.to(entity));
    }

    @Override
    public SkillsDto findById(Integer id) {
        SkillsDao byId = skillsRepository.findById(id);
        return skillsConverter.from(byId);
    }
}
