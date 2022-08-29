package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.ProjectsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ProjectsRepository implements Repository<ProjectsDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO goit_dev.projects (id, project_name, project_type, " +
            "comments, cost) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, project_name, project_type, comments, cost " +
            "FROM goit_dev.projects WHERE id = ?";

    public ProjectsRepository(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public void save(ProjectsDao entity) {
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
        }

    }

    @Override
    public void update(ProjectsDao entity) {

    }

    @Override
    public ProjectsDao findById(Integer id) {
        ResultSet resultSet = null;
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
        return null;
    }
    private ProjectsDao convert(ResultSet resultSet) throws SQLException {
        ProjectsDao projectsDao = new ProjectsDao();
        while (resultSet.next()) {
            projectsDao.setId(resultSet.getInt("id"));
            projectsDao.setProjectName(resultSet.getString("project_name"));
            projectsDao.setProjectType(resultSet.getString("project_type"));
            projectsDao.setComments(resultSet.getString("comments"));
            projectsDao.setCost(resultSet.getInt("cost"));
        }
        return projectsDao;
    }
}
