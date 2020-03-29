package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

    private static final String url = "jdbc:mysql://localhost:3306/codelearner";
    private static final String user = "root";
    private static final String password = "";

    private Connection con = null;


    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) System.out.println("Successfully connected to MySQL database");
            else System.out.println("Connection Error");
            return conn;

            /*String url = "jdbc:mysql://localhost:3306/codelearner";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "");
            Connection dbConnection = DriverManager.getConnection(url, info);
            if (dbConnection != null) {
                System.out.println("Successfully connected to MySQL database test");
            }
            return dbConnection;
            */

        }

        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;

            /*
            System.out.println("An error occurred while connecting MySQL database");
            ex.printStackTrace();
            return null;
            */

        }
    }
}
