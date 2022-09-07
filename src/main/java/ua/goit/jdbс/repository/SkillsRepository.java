package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.SkillsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SkillsRepository implements Repository<SkillsDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO goit_dev.skills (id, branch, skill_level) " +
            "VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, branch, skill_level " +
            "FROM goit_dev.skills WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE goit_dev.skills " +
            "SET branch = ?, skill_level = ? WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM goit_dev.skills WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, branch, skill_level FROM goit_dev.skills;";


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
            throw new RuntimeException("Skill is not created");
        }
        return entity;
    }

    @Override
    public void update(SkillsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {

            statement.setString(1, entity.getBranch());
            statement.setString(2, entity.getSkillLevel());
            statement.setInt(3, entity.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Skill is not updated");
        }
    }

    @Override
    public void delete(SkillsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, entity.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Skill is not deleted");
        }
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
        List<SkillsDao> daoList = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                SkillsDao skillsDao = new SkillsDao();
                skillsDao.setId(resultSet.getInt("id"));
                skillsDao.setBranch(resultSet.getString("branch"));
                skillsDao.setSkillLevel(resultSet.getString("skill_level"));
                daoList.add(skillsDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Skills not found");
        }
        return daoList;
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
