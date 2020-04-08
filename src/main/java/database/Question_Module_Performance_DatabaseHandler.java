package database;

import java.sql.*;

public class Question_Module_Performance_DatabaseHandler {

    private static Connection connection = DatabaseConnector.getConnection();

    public static ResultSet getQuestions() throws SQLException {
        String query = "SELECT * FROM question";
        PreparedStatement pstmt = connection.prepareStatement(query);
        return pstmt.executeQuery(query);
    }

    public static ResultSet getModules() throws SQLException {
        String query = "SELECT moduleName FROM question_module";
        PreparedStatement pstmt = connection.prepareStatement(query);
        return pstmt.executeQuery(query);
    }

    public static String getModuleFromNumber(int moduleNumber) throws SQLException {

        String query = "SELECT moduleName FROM module WHERE moduleID = '" + moduleNumber + "'";
        PreparedStatement pstmt = connection.prepareStatement(query);
        ResultSet results = pstmt.executeQuery(query);

        String moduleName = null;

        while (results.next()) moduleName = results.getString("moduleName");

        System.out.println("query results: " + moduleName);

        return moduleName;
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

    public static ResultSet getInfoFrom_User_Module_Table(String username) throws SQLException {

        String query = "SELECT * FROM `user_module_score` where username = '" + username + "'";
        PreparedStatement pstmt = connection.prepareStatement(query);

        return pstmt.executeQuery(query);
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
