package ua.goit.jdbсservlets.service.convert;

import ua.goit.jdbсservlets.dao.SkillsDao;
import ua.goit.jdbсservlets.dto.SkillsDto;

public class SkillsConverter implements Converter<SkillsDto, SkillsDao> {
    @Override
    public SkillsDto from(SkillsDao entity) {
        SkillsDto dto = new SkillsDto();
        dto.setId(entity.getId());
        dto.setBranch(entity.getBranch());
        dto.setSkillLevel(entity.getSkillLevel());
        return dto;
    }

    @Override
    public SkillsDao to(SkillsDto entity) {
        SkillsDao dao = new SkillsDao();
        dao.setId(entity.getId());
        dao.setBranch(entity.getBranch());
        dao.setSkillLevel(entity.getSkillLevel());
        return dao;
    }
}
