package ua.goit.jdbcConnection.feature.storage;

import ua.goit.jdbcConnection.LogIn;
import ua.goit.jdbcConnection.feature.prefs.Prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Storage {
    private static final Storage INSTANCE = new Storage();

    private Connection connection;
    private Storage() {
        try {
            LogIn user = new LogIn();
            String dbUser = user.getUserName();
            String dbPass = user.getUserPassword();
            String connectionUrl = new Prefs().getString(Prefs.DB_CONNECTION_URL);
            connection = DriverManager.getConnection(connectionUrl, dbUser, dbPass);
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate("CREATE TABLE goit_dev.test_table (name VARCHAR(100))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql) {
        try(Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    public static Storage getInstance(){
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
