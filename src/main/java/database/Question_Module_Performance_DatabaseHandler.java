package database;

import java.sql.*;

public class Question_Module_Performance_DatabaseHandler {

    private static Connection connection = DatabaseConnector.getConnection();

    public static ResultSet getQuestions() throws SQLException {
        String query = "SELECT * FROM question";
        PreparedStatement pstmt = connection.prepareStatement(query);
        return pstmt.executeQuery(query);
    }

    public static void addModule(String moduleName) throws SQLException {

        Statement s = connection.createStatement();
        s.executeUpdate("INSERT INTO `module` (moduleName) " +
                "VALUES ('" + moduleName + "')");
    }

    public static void deleteModule(String moduleName) throws SQLException {

        String query = "DELETE from module where moduleName = ?";

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, moduleName);

        preparedStmt.execute();
    }

    public static ResultSet getInfoFrom_User_Module_Score_Table(String username) throws SQLException {

        String query = "SELECT * FROM `user_module_score` where username = '" + username + "'";
        PreparedStatement pstmt = connection.prepareStatement(query);

        return pstmt.executeQuery(query);
    }

    public static ResultSet getInfoFrom_User_Score_Performance_Table(String username) throws SQLException {

        String query = "SELECT * FROM `user_score_performance` where username = '" + username + "'";
        PreparedStatement pstmt = connection.prepareStatement(query);

        return pstmt.executeQuery(query);
    }

}
