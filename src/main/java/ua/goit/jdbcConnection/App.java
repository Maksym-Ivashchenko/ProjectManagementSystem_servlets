package ua.goit.jdbcConnection;


import ua.goit.jdbcConnection.feature.storage.DatabaseInitService;
import ua.goit.jdbcConnection.feature.storage.Storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Storage storage = Storage.getInstance();
//        new DatabaseInitService().initDb(storage);

        //SELECT
        String selectSql = "SELECT sum(d.salary), p.project_name\n" +
                "FROM goit_dev.developers AS d\n" +
                "INNER JOIN goit_dev.developers_projects AS dp ON d.id = dp.developer_id\n" +
                "INNER JOIN goit_dev.projects AS p ON dp.project_id = p.id\n" +
                "WHERE p.project_name = 'Project_5'\n" +
                "GROUP BY p.project_name;";

        try {
            Statement st = storage.getConnection().createStatement();
            ResultSet rs = st.executeQuery(selectSql);

            if (rs.next()) {
                //Extract
                int sum = rs.getInt("sum");
                String projectName = rs.getString("project_name");

                System.out.println("sum = " + sum);
                System.out.println("Project = " + projectName);

            } else {
                System.out.println("Not found");
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
