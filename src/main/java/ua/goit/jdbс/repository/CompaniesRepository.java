package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.CompaniesDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompaniesRepository implements Repository<CompaniesDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO companies (company_name, city, email) " +
            "VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, company_name, city, email " +
            "FROM companies WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE companies " +
            "SET company_name = ?, city = ?, email = ?" +
            "WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM companies WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, company_name, city, email " +
            "FROM companies;";
    private static final String COUNT_OF_COLUMN = "SELECT * FROM companies;";
    public CompaniesRepository(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public CompaniesDao save(CompaniesDao entity) {
        try (Connection connection = connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, entity.getCompanyName());
            statement.setString(2, entity.getCity());
            statement.setString(3, entity.getEmail());

            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating company failed, no ID obtained.");
                }
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Company is not created");
        }
        return entity;
    }

    @Override
    public CompaniesDao update(CompaniesDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {

            statement.setString(1, entity.getCompanyName());
            statement.setString(2, entity.getCity());
            statement.setString(3, entity.getEmail());
            statement.setInt(4, entity.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Company is not updated");
        }
        return entity;
    }

    @Override
    public void delete(CompaniesDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, entity.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Company is not deleted");
        }
    }

    @Override
    public CompaniesDao findById(Integer id) {
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
    public List<CompaniesDao> findAll() {
        List<CompaniesDao> daoList = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CompaniesDao companiesDao = new CompaniesDao();
                setParameters(resultSet, companiesDao);
                daoList.add(companiesDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Companies not found");
        }
        return daoList;
    }

    public int getCountOfColumn() {
        int numOfCol=0;
        try(Connection connection = connector.getConnection();
        PreparedStatement statement = connection.prepareStatement(COUNT_OF_COLUMN)) {
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            numOfCol=metaData.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numOfCol;
    }

    private CompaniesDao convert(ResultSet resultSet) throws SQLException {
        CompaniesDao companiesDao = new CompaniesDao();
        while (resultSet.next()) {
            setParameters(resultSet, companiesDao);
        }
        return companiesDao;
    }

    private void setParameters(ResultSet resultSet, CompaniesDao companiesDao) throws SQLException {
        companiesDao.setId(resultSet.getInt("id"));
        companiesDao.setCompanyName(resultSet.getString("company_name"));
        companiesDao.setCity(resultSet.getString("city"));
        companiesDao.setEmail(resultSet.getString("email"));
    }

}
