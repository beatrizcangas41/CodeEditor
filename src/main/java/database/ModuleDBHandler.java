package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class ModuleDBHandler {

    static Connection connection = DatabaseConnector.getConnection();

    public static ResultSet getAllModules() throws SQLException {
        String query = "SELECT moduleName FROM question_module";
        PreparedStatement pstmt = ModuleDBHandler.connection.prepareStatement(query);
        return pstmt.executeQuery(query);
    }

    public static String getModuleNameFromID(int moduleNumber) throws SQLException {

        String query = "SELECT moduleName FROM module WHERE moduleID = '" + moduleNumber + "'";
        PreparedStatement pstmt = ModuleDBHandler.connection.prepareStatement(query);
        ResultSet results = pstmt.executeQuery(query);

        String moduleName = null;

        while (results.next()) moduleName = results.getString("moduleName");
        System.out.println("query results: " + moduleName);

        return moduleName;
    }

    public static int getModuleIDFromName(String name) throws SQLException {

        int moduleID = 0;

        String query2 = "SELECT moduleID FROM module WHERE moduleName = '" + name + "'";
        PreparedStatement pstmt2 = connection.prepareStatement(query2);
        ResultSet results2 = pstmt2.executeQuery(query2);
        while (results2.next()) moduleID = Integer.parseInt(results2.getString("moduleID"));
        System.out.println("query results: " + moduleID);

        return moduleID;
    }

    public static String getModuleFromLanguageAndNumber(int moduleNumber, String language) throws SQLException {

        System.out.println("programming language: " + language + "\n" + "Module Number: " + moduleNumber);

        String query1 = "SELECT programming_language_ID FROM programming_language WHERE programming_language_name = '" + language + "'";
        PreparedStatement pstmt1 = ModuleDBHandler.connection.prepareStatement(query1);
        ResultSet results1 = pstmt1.executeQuery(query1);

        int languageID = 0;
        while (results1.next()) languageID = Integer.parseInt(results1.getString("programming_language_ID"));
        System.out.println("query results: " + languageID);

        String query2 = "SELECT moduleName FROM module WHERE moduleID = '" + moduleNumber + "' AND programming_language_ID = '" + languageID + "'";
        PreparedStatement pstmt2 = ModuleDBHandler.connection.prepareStatement(query2);
        ResultSet results2 = pstmt2.executeQuery(query2);

        String moduleName = null;
        while (results2.next()) moduleName = results2.getString("moduleName");
        System.out.println("query results: " + moduleName);

        return moduleName;
    }

    public static void addModule(String moduleName) throws SQLException {

        Statement s = ModuleDBHandler.connection.createStatement();
        s.executeUpdate("INSERT INTO `module` (moduleName) " +
                "VALUES ('" + moduleName + "')");
    }

    public static void deleteModule(String moduleName) throws SQLException {

        String query = "DELETE from module where moduleName = ?";

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, moduleName);

        preparedStmt.execute();
    }
}
