package database;

import java.sql.*;

public class ScoreAndPerfDBHandler {

    private static Connection connection = DatabaseConnector.getConnection();

    public static void addScore(double score, int userID, int moduleID, int programming_language_ID, int numberOfCorrectAnswers,
                                int numberOfIncorrectAnswers, int totalNumberOfAnswers) throws SQLException {

        Statement s = connection.createStatement();
        s.executeUpdate("INSERT INTO `score`(score, userID, moduleID, programming_language_ID, " +
                "numberOfCorrectAnswers, numberOfIncorrectAnswers, totalNumberOfAnswers)" +
                " VALUE ('" + score + "' , '" +
                            userID + "', '" +
                            moduleID + "', '" +
                            programming_language_ID + "', '" +
                            numberOfCorrectAnswers + "', '" +
                            numberOfIncorrectAnswers + "', '" +
                            totalNumberOfAnswers + "')");
    }

    public static ResultSet getScoresOfUser(int userId) throws SQLException {
        String query = "SELECT score FROM score WHERE userID = '" + userId + "'";
        PreparedStatement pstmt = ModuleDBHandler.connection.prepareStatement(query);
        return pstmt.executeQuery(query);
    }

    public static boolean checkIfUserExistsInPerformance(int userID) throws SQLException {

        String query = "SELECT userID FROM performance WHERE userID = '" + userID + "'";
        PreparedStatement pstmt = ModuleDBHandler.connection.prepareStatement(query);
        int a;
        ResultSet resultSet = pstmt.executeQuery(query);
        while (resultSet.next()) {
            a = resultSet.getInt("userID");
            return a == userID;
        }
        return false;
    }

    public static void addPerformance(double performance, int userID) throws SQLException {

        Statement s = connection.createStatement();
        s.executeUpdate("INSERT INTO `performance`(performance, userID)" +
                " VALUE ('" + performance + "','" + userID + "')");
    }

    public static void updatePerformance(double performance, int userID) throws SQLException {

        String query = "UPDATE performance SET performance = ? where userID = ?";
        PreparedStatement pstmt1 = connection.prepareStatement(query);

        pstmt1.setDouble(1, performance);
        pstmt1.setInt(2, userID);

        pstmt1.execute();
    }
}
