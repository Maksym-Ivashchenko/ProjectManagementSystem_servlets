package ua.goit.jdbс.dto;

public class ProjectsDto {
    Integer id;
    String projectName;
    String projectType;
    String comments;
    Integer cost;

    public ProjectsDto() {
    }

    public ProjectsDto(Integer id, String projectName, String projectType, String comments, Integer cost) {
        this.id = id;
        this.projectName = projectName;
        this.projectType = projectType;
        this.comments = comments;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
