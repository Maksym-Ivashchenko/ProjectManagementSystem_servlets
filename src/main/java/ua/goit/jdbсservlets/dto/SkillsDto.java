package ua.goit.jdbсservlets.dto;

public class SkillsDto {
    Integer id;
    String branch;
    String skillLevel;

    public SkillsDto() {
    }

    public SkillsDto(Integer id, String branch, String skillLevel) {
        this.id = id;
        this.branch = branch;
        this.skillLevel = skillLevel;
    }

    public SkillsDto(String branch, String skillLevel) {
        this.branch = branch;
        this.skillLevel = skillLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "SkillsDto{" +
                "id=" + id +
                ", branch='" + branch + '\'' +
                ", skillLevel='" + skillLevel + '\'' +
                '}';
    }
}
