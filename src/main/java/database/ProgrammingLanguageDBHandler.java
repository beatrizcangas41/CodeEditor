package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgrammingLanguageDBHandler {

    private static Connection connection = DatabaseConnector.getConnection();

    public static int getLanguageIDFromName(String name) throws SQLException {
        int languageID = 0;
        String query1 = "SELECT programming_language_ID FROM programming_language WHERE programming_language_name = '" + name + "'";
        PreparedStatement pstmt1 = connection.prepareStatement(query1);
        ResultSet results1 = pstmt1.executeQuery(query1);
        while (results1.next()) languageID = Integer.parseInt(results1.getString("programming_language_ID"));
        System.out.println("query results: " + languageID);

        return languageID;
    }

    public static String getLanguageNameFromID(int languageID) throws SQLException {

        String query = "SELECT programming_language_name FROM programming_language WHERE programming_language_ID = '" + languageID + "'";
        PreparedStatement pstmt = ProgrammingLanguageDBHandler.connection.prepareStatement(query);
        ResultSet results = pstmt.executeQuery(query);

        String languageName = null;

        while (results.next()) languageName = results.getString("programming_language_name");
        System.out.println("query results: " + languageName);

        return languageName;
    }

    public static ResultSet getAllLanguages() throws SQLException {

        String query = "SELECT programming_language_name FROM programming_language";
        PreparedStatement pstmt = ProgrammingLanguageDBHandler.connection.prepareStatement(query);
        return pstmt.executeQuery(query);
    }

}
