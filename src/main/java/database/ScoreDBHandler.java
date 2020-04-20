package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ScoreDBHandler {

    private static Connection connection = DatabaseConnector.getConnection();

    public static void addScore(double score, int userID, int moduleID, int programming_language_ID, int numberOfCorrectAnswers,
                                int numberOfIncorrectAnswers, int totalNumberOfAnswers) throws SQLException {

        Statement s = connection.createStatement();
        s.executeUpdate("INSERT INTO `score`(score, userID, moduleID, programming_language_ID, numberOfCorrectAnswers, numberOfIncorrectAnswers, totalNumberOfAnswers)" +
                " VALUE ('" + score + "' , '" +
                            userID + "', '" +
                            moduleID + "', '" +
                            programming_language_ID + "', '" +
                            numberOfCorrectAnswers + "', '" +
                            numberOfIncorrectAnswers + "', '" +
                            totalNumberOfAnswers + "')");
    }
}
