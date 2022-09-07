package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.SkillsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class SkillsRepository implements Repository<SkillsDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO goit_dev.skills (id, branch, skill_level) " +
            "VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, branch, skill_level " +
            "FROM goit_dev.skills WHERE id = ?";

    public SkillsRepository(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public SkillsDao save(SkillsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getBranch());
            statement.setString(3, entity.getSkillLevel());

            statement.execute();

        } catch (
                SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Skill not created");
        }
        return entity;
    }

    @Override
    public void update(SkillsDao entity) {

    }

    @Override
    public void delete(SkillsDao entity) {

    }

    @Override
    public SkillsDao findById(Integer id) {
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
    public List<SkillsDao> findAll() {
        return null;
    }
    private SkillsDao convert(ResultSet resultSet) throws SQLException {
        SkillsDao skillsDao = new SkillsDao();
        while (resultSet.next()) {
            skillsDao.setId(resultSet.getInt("id"));
            skillsDao.setBranch(resultSet.getString("branch"));
            skillsDao.setSkillLevel(resultSet.getString("skill_level"));
        }
        return skillsDao;
    }
}
