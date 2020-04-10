package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class ModuleDBHandler {

    private static Connection connection = DatabaseConnector.getConnection();

    public static ResultSet getModules() throws SQLException {
        String query = "SELECT moduleName FROM question_module";
        PreparedStatement pstmt = ModuleDBHandler.connection.prepareStatement(query);
        return pstmt.executeQuery(query);
    }

    public static String getModuleFromNumber(int moduleNumber) throws SQLException {

        String query = "SELECT moduleName FROM module WHERE moduleID = '" + moduleNumber + "'";
        PreparedStatement pstmt = ModuleDBHandler.connection.prepareStatement(query);
        ResultSet results = pstmt.executeQuery(query);

        String moduleName = null;

        while (results.next()) moduleName = results.getString("moduleName");
        System.out.println("query results: " + moduleName);

        return moduleName;
    }

    public static void addModule(String moduleName) throws SQLException {

        Statement s = ModuleDBHandler.connection.createStatement();
        s.executeUpdate("INSERT INTO `module` (moduleName) " +
                "VALUES ('" + moduleName + "')");
    }
}
