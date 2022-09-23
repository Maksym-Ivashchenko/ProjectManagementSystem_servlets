package ua.goit.jdbс.repository;

import ua.goit.jdbс.config.DatabaseManagerConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JoinedSQLRequests {
    private final DatabaseManagerConnector connector;
    static final String COUNT_OF_COLUMN = "SELECT COUNT(*)" +
            " FROM INFORMATION_SCHEMA.COLUMNS" +
            " WHERE table_name = ?;";

    public JoinedSQLRequests(DatabaseManagerConnector connector) {
        this.connector = connector;
    }

    public Integer getCountOfColumn(String tableName) {
        int result = 0;
        ResultSet resultSet;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(COUNT_OF_COLUMN)) {
            statement.setString(1, tableName);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
