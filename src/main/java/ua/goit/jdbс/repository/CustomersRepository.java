package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.CustomersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class CustomersRepository implements Repository<CustomersDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO goit_dev.customers (id, customer_name, country, email) " +
            "VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, customer_name, country, email " +
            "FROM goit_dev.customers WHERE id = ?";

    public CustomersRepository(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public void save(CustomersDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getCustomerName());
            statement.setString(3, entity.getCountry());
            statement.setString(4, entity.getEmail());

            statement.execute();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CustomersDao entity) {

    }

    @Override
    public CustomersDao findById(Integer id) {
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
    public List<CustomersDao> findAll() {
        return null;
    }
    private CustomersDao convert(ResultSet resultSet) throws SQLException {
        CustomersDao customersDao = new CustomersDao();
        while (resultSet.next()) {
            customersDao.setId(resultSet.getInt("id"));
            customersDao.setCustomerName(resultSet.getString("customer_name"));
            customersDao.setCountry(resultSet.getString("country"));
            customersDao.setEmail(resultSet.getString("email"));
        }
        return customersDao;
    }
}
