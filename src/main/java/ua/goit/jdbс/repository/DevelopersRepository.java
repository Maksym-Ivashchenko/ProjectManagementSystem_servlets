package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.DevelopersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DevelopersRepository implements Repository<DevelopersDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO goit_dev.developers (id, developer_name, age, gender, " +
            "different, salary) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT id, developer_name, age, gender, different, salary " +
            "FROM goit_dev.developers WHERE id = ?;";
    private static final String UPDATE_BY_ID = "UPDATE goit_dev.developers " +
            "SET developer_name = ?, age = ?, gender = ?, different = ?, salary = ?" +
            "WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM goit_dev.developers WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, developer_name, age, gender, different, salary " +
            "FROM goit_dev.developers;";

    public DevelopersRepository(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public DevelopersDao save(DevelopersDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getDeveloperName());
            statement.setInt(3, entity.getAge());
            statement.setString(4, entity.getGender());
            statement.setString(5, entity.getDifferent());
            statement.setInt(6, entity.getSalary());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Developer is not created");
        }
        return entity;
    }

    @Override
    public void update(DevelopersDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {

            statement.setString(1, entity.getDeveloperName());
            statement.setInt(2, entity.getAge());
            statement.setString(3, entity.getGender());
            statement.setString(4, entity.getDifferent());
            statement.setInt(5, entity.getSalary());
            statement.setInt(6, entity.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Developer is not updated");
        }
    }

    @Override
    public void delete(DevelopersDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, entity.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Developer is not deleted");
        }
    }

    @Override
    public DevelopersDao findById(Integer id) {
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
    public List<DevelopersDao> findAll() {
        List<DevelopersDao> daoList = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            resultSet = statement.executeQuery();
            while (resultSet.next())
            daoList.add(convert(resultSet));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daoList;
    }

    private DevelopersDao convert(ResultSet resultSet) throws SQLException {
        DevelopersDao developersDao = new DevelopersDao();
        while (resultSet.next()) {
            developersDao.setId(resultSet.getInt("id"));
            developersDao.setDeveloperName(resultSet.getString("developer_name"));
            developersDao.setAge(resultSet.getInt("age"));
            developersDao.setGender(resultSet.getString("gender"));
            developersDao.setDifferent(resultSet.getString("different"));
            developersDao.setSalary(resultSet.getInt("salary"));
        }
        return developersDao;
    }
}
