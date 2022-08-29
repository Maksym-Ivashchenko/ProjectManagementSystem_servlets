package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;
import ua.goit.jdbс.dao.CompaniesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class CompaniesRepository implements Repository<CompaniesDao> {
    private final DatabaseManagerConnector connector;

    private static final String INSERT = "INSERT INTO goit_dev.companies (id, company_name, city, email) " +
            "VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, company_name, city, email " +
            "FROM goit_dev.companies WHERE id = ?";

    public CompaniesRepository(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public void save(CompaniesDao entity) {
        try (Connection connection = connector.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT)) {

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getCompanyName());
            statement.setString(3, entity.getCity());
            statement.setString(4, entity.getEmail());

            statement.execute();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(CompaniesDao entity) {

    }

    @Override
    public CompaniesDao findById(Integer id) {
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
    public List<CompaniesDao> findAll() {
        return null;
    }

    private CompaniesDao convert(ResultSet resultSet) throws SQLException {
        CompaniesDao companiesDao = new CompaniesDao();
        while (resultSet.next()) {
            companiesDao.setId(resultSet.getInt("id"));
            companiesDao.setCompanyName(resultSet.getString("company_name"));
            companiesDao.setCity(resultSet.getString("city"));
            companiesDao.setEmail(resultSet.getString("email"));
        }
        return companiesDao;
    }

}
