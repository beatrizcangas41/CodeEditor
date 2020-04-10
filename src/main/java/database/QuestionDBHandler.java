package database;

import java.sql.*;
import java.util.Objects;

public class QuestionDBHandler {
    private static Connection connection = DatabaseConnector.getConnection();

    public static ResultSet getQuestions() throws SQLException {

        String query = "SELECT * FROM question";
        PreparedStatement pstmt = connection.prepareStatement(query);
        return pstmt.executeQuery(query);
    }

    public static String getQuestionFromDescription(String description) throws SQLException {

        String formattedString = description.replace("[", "").replace("]", "");
        //String string = formattedString.replaceAll("[\\[\\](){}]","");

        String query = "SELECT questionID FROM question where description = '" + description + "'";
        PreparedStatement pstmt = connection.prepareStatement(query);
        ResultSet results = pstmt.executeQuery(query);

        String questionID = null;

        while (results.next()) {
            questionID = results.getString("questionID");
        }

        return questionID;
    }

    public static boolean verifyQuestionAnswerByDescriptionAndSolution(String description, String solution) throws SQLException {

        String query1 = "SELECT * FROM question WHERE description = '" + description + "' AND solution = '" + solution + "'";

        PreparedStatement pstmt = connection.prepareStatement(query1);
        ResultSet results = pstmt.executeQuery(query1);

        String dbDescription = null;
        // String dbAuthor = null;

        while (results.next()) {
            dbDescription = results.getString("description");
            //description = results.getString("description");

            System.out.println("db description: " + dbDescription);
            // System.out.println("db description: " + dbDescription);
        }

        return Objects.equals(dbDescription, description);
    }

    public static void addQuestion(String description, String choice_solution, String solution, Double moduleID) throws SQLException {

        Statement s = connection.createStatement();

        s.executeUpdate("INSERT INTO `question`(description, choice_solution, solution, moduleID)" +
                " VALUE ('" + description + "' , '" + choice_solution + "', '" + solution + "', '" + moduleID + "')");
    }

    public static void deleteQuestion(String description, String solution) throws SQLException {

        String query = "DELETE from question where description = ? AND solution = ?";

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, description);
        preparedStmt.setString(2, solution);

        preparedStmt.execute();
    }
}
