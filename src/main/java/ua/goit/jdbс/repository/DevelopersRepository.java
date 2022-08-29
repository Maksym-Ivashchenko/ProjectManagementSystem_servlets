package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.DevelopersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class DevelopersRepository implements Repository<DevelopersDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO goit_dev.developers (id, developer_name, age, gender, " +
            "different, salary) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, developer_name, age, gender, different, salary " +
            "FROM goit_dev.developers WHERE id = ?";

    public DevelopersRepository(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public void save(DevelopersDao entity) {
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
        }
    }

    @Override
    public void update(DevelopersDao entity) {

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
        return null;
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
