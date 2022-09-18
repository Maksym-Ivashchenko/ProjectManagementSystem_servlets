package ua.goit.jdbс.dao;

import java.time.LocalDate;

public class ProjectsDao {
    Integer id;
    String projectName;
    String projectType;
    String comments;
    Integer cost;
    LocalDate dateCreated;

    public ProjectsDao() {
    }

    public ProjectsDao(Integer id, String projectName, String projectType, String comments, Integer cost, LocalDate dateCreated) {
        this.id = id;
        this.projectName = projectName;
        this.projectType = projectType;
        this.comments = comments;
        this.cost = cost;
        this.dateCreated = dateCreated;
    }

    public ProjectsDao(String projectName, String projectType, String comments, Integer cost, LocalDate dateCreated) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.comments = comments;
        this.cost = cost;
        this.dateCreated = dateCreated;
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "ProjectsDao{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectType='" + projectType + '\'' +
                ", comments='" + comments + '\'' +
                ", cost=" + cost +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
