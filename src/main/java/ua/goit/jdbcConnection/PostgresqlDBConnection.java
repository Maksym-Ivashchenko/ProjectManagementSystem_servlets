package ua.goit.jdbcConnection;

import java.sql.*;

public class PostgresqlDBConnection {
    public static void main(String[] args) {
        LogIn user = new LogIn();
        String dbUrl = "jdbc:postgresql://localhost:5455/postgres";
        String dbUser = user.getUserName();
        String dbPass = user.getUserPassword();

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE test_table (name VARCHAR(100))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
