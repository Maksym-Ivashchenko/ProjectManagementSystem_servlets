package ua.goit.jdbсservlets.repository;

import ua.goit.jdbсservlets.config.DatabaseManagerConnector;
import ua.goit.jdbсservlets.dao.DevelopersDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DevelopersRepository extends JoinedSQLRequests implements Repository<DevelopersDao> {
    private final DatabaseManagerConnector connector;
    private static final String INSERT = "INSERT INTO developers (developer_name, age, gender, " +
            "different, salary) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT id, developer_name, age, gender, different, salary" +
            " FROM developers WHERE id = ?;";
    private static final String UPDATE_BY_ID = "UPDATE developers" +
            " SET developer_name = ?, age = ?, gender = ?, different = ?, salary = ?" +
            " WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM developers WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, developer_name, age, gender, different, salary " +
            "FROM developers;";
    private static final String LIST_OF_ALL_DEVELOPERS_BY_BRANCH =
            "SELECT d.id, d.developer_name, d.age, d.gender, d.different, d.salary FROM developers AS d" +
                    " JOIN developers_skills AS ds ON d.id = ds.developer_id" +
                    " JOIN skills AS s ON s.id = ds.skill_id" +
                    " WHERE s.branch = ?;";
    private static final String LIST_OF_ALL_DEVELOPERS_BY_SKILL_LEVEL =
            "SELECT d.id, d.developer_name, d.age, d.gender, d.different, d.salary FROM developers AS d" +
                    " JOIN developers_skills AS ds ON d.id = ds.developer_id" +
                    " JOIN skills AS s ON s.id = ds.skill_id" +
                    " WHERE s.skill_level = ?;";

    public DevelopersRepository(DatabaseManagerConnector connector) {
        super(connector);
        this.connector = connector;
    }

    @Override
    public DevelopersDao save(DevelopersDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, entity.getDeveloperName());
            statement.setInt(2, entity.getAge());
            statement.setString(3, entity.getGender());
            statement.setString(4, entity.getDifferent());
            statement.setInt(5, entity.getSalary());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating developer failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Developer is not created");
        }
        return entity;
    }

    @Override
    public DevelopersDao update(DevelopersDao entity) {
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
        return entity;
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
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {

            statement.setInt(1, id);

            resultSet = statement.executeQuery();
            return Objects.isNull(resultSet) ? new DevelopersDao() : convert(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DevelopersDao();
    }

    @Override
    public List<DevelopersDao> findAll() {
        List<DevelopersDao> daoList = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DevelopersDao developersDao = new DevelopersDao();
                setParameters(resultSet, developersDao);
                daoList.add(developersDao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Developers not found");
        }
        return daoList;
    }

    public List<DevelopersDao> getListOfAllDevelopersByBranch(String branch) {
        List<DevelopersDao> daoList = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(LIST_OF_ALL_DEVELOPERS_BY_BRANCH)) {
            statement.setString(1, branch);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DevelopersDao developersDao = new DevelopersDao();
                setParameters(resultSet, developersDao);
                daoList.add(developersDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Request failed!");
        }
        return daoList;
    }

    public List<DevelopersDao> getListOfAllDevelopersBySkillLevel(String skillLevel) {
        List<DevelopersDao> daoList = new ArrayList<>();
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(LIST_OF_ALL_DEVELOPERS_BY_SKILL_LEVEL)) {
            statement.setString(1, skillLevel);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DevelopersDao developersDao = new DevelopersDao();
                setParameters(resultSet, developersDao);
                daoList.add(developersDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Request failed!");
        }
        return daoList;
    }

    private void setParameters(ResultSet resultSet, DevelopersDao developersDao) throws SQLException {
        developersDao.setId(resultSet.getInt("id"));
        developersDao.setDeveloperName(resultSet.getString("developer_name"));
        developersDao.setAge(resultSet.getInt("age"));
        developersDao.setGender(resultSet.getString("gender"));
        developersDao.setDifferent(resultSet.getString("different"));
        developersDao.setSalary(resultSet.getInt("salary"));
    }

    private DevelopersDao convert(ResultSet resultSet) throws SQLException {
        DevelopersDao developersDao = new DevelopersDao();
        while (resultSet.next()) {
            setParameters(resultSet, developersDao);
        }
        return developersDao;
    }
}
