package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.ProjectsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjectsRepository implements Repository<ProjectsDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO goit_dev.projects (id, project_name, project_type, " +
            "comments, cost) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, project_name, project_type, comments, cost " +
            "FROM goit_dev.projects WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE goit_dev.projects " +
            "SET project_name = ?, project_type = ?, comments = ?, cost = ?" +
            "WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM goit_dev.projects WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, project_name, project_type, comments, cost " +
            "FROM goit_dev.projects;";
    private static final String SALARY_OF_ALL_DEVELOPERS = "SELECT sum(salary) FROM goit_dev.developers AS d\n" +
            "JOIN goit_dev.developers_projects AS dp ON d.id = dp.developer_id\n" +
            "JOIN goit_dev.projects AS p ON p.id = dp.project_id\n" +
            "WHERE p.project_name = ?;";
    private static final String LIST_OF_PROJECT_DEVELOPERS = "SELECT developer_name FROM goit_dev.developers AS d\n" +
            "JOIN goit_dev.developers_projects AS dp ON d.id = dp.developer_id\n" +
            "JOIN goit_dev.projects AS p ON p.id = dp.project_id\n" +
            "WHERE p.project_name = ?;";
    private static final String LIST_OF_PROJECTS_IN_THE_FORMAT =
            "SELECT p.date_created, p.project_name, COUNT(d.developer_name) FROM goit_dev.projects AS p\n" +
            "JOIN goit_dev.developers_projects AS dp ON p.id = dp.project_id\n" +
            "JOIN goit_dev.developers AS d ON d.id = dp.developer_id\n" +
            "GROUP BY p.date_created, p.project_name\n" +
            "ORDER BY project_name;";

    public ProjectsRepository(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public ProjectsDao save(ProjectsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getProjectName());
            statement.setString(3, entity.getProjectType());
            statement.setString(4, entity.getComments());
            statement.setInt(5, entity.getCost());

            statement.execute();

        } catch (
                SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Project is not created");
        }
        return entity;
    }

    @Override
    public void update(ProjectsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {

            statement.setString(1, entity.getProjectName());
            statement.setString(2, entity.getProjectType());
            statement.setString(3, entity.getComments());
            statement.setInt(4, entity.getCost());
            statement.setInt(5, entity.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Project is not updated");
        }
    }

    @Override
    public void delete(ProjectsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, entity.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Project is not deleted");
        }
    }

    @Override
    public ProjectsDao findById(Integer id) {
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {

            statement.setInt(1, id);

            resultSet = statement.executeQuery();
            return Objects.isNull(resultSet) ? null : convert(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProjectsDao> findAll() {
        List<ProjectsDao> daoList = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProjectsDao projectsDao = new ProjectsDao();
                setParameters(resultSet, projectsDao);
                daoList.add(projectsDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Projects not found");
        }
        return daoList;
    }

    public Integer getSalaryOfAllDevelopersFromProject(String projectName) {
        ResultSet resultSet;
        int result = 0;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SALARY_OF_ALL_DEVELOPERS)) {
            statement.setString(1, projectName);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Request failed!");
        }
        return result;
    }

    public List<String> getListOfProjectDevelopers(String projectName) {
        List<String> daoList = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(LIST_OF_PROJECT_DEVELOPERS)) {
            statement.setString(1, projectName);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                daoList.add(resultSet.getString("developer_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Request failed!");
        }
        return daoList;
    }

    public List<String> getListOfProjectsInTheFormat() {
        List<String> results = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(LIST_OF_PROJECTS_IN_THE_FORMAT)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                List<String> daoList = new ArrayList<>();
                daoList.add(resultSet.getString("date_created"));
                daoList.add(resultSet.getString("project_name"));
                daoList.add(resultSet.getString("count"));
                results.add(daoList.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Request failed!");
        }
        return results;
    }


    private ProjectsDao convert(ResultSet resultSet) throws SQLException {
        ProjectsDao projectsDao = new ProjectsDao();
        while (resultSet.next()) {
            setParameters(resultSet, projectsDao);
        }
        return projectsDao;
    }

    private void setParameters(ResultSet resultSet, ProjectsDao projectsDao) throws SQLException {
        projectsDao.setId(resultSet.getInt("id"));
        projectsDao.setProjectName(resultSet.getString("project_name"));
        projectsDao.setProjectType(resultSet.getString("project_type"));
        projectsDao.setComments(resultSet.getString("comments"));
        projectsDao.setCost(resultSet.getInt("cost"));
    }
}
