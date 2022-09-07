package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.CustomersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomersRepository implements Repository<CustomersDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO goit_dev.customers (id, customer_name, country, email) " +
            "VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, customer_name, country, email " +
            "FROM goit_dev.customers WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE goit_dev.customers " +
            "SET customer_name = ?, country = ?, email = ?" +
            "WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM goit_dev.customers WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, customer_name, country, email " +
            "FROM goit_dev.customers;";


    public CustomersRepository(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public CustomersDao save(CustomersDao entity) {
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
            throw new RuntimeException("Customer is not created");
        }
        return entity;
    }

    @Override
    public void update(CustomersDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {

            statement.setString(1, entity.getCustomerName());
            statement.setString(2, entity.getCountry());
            statement.setString(3, entity.getEmail());
            statement.setInt(4, entity.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Customer is not updated");
        }
    }

    @Override
    public void delete(CustomersDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, entity.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Customer is not deleted");
        }
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
        List<CustomersDao> daoList = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CustomersDao customersDao = new CustomersDao();
                customersDao.setId(resultSet.getInt("id"));
                customersDao.setCustomerName(resultSet.getString("customer_name"));
                customersDao.setCountry(resultSet.getString("country"));
                customersDao.setEmail(resultSet.getString("email"));
                daoList.add(customersDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Customers not found");
        }
        return daoList;
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
