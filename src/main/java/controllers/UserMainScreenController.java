package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Report;
import model.User;
import util.SceneChange;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static database.ModuleDBHandler.getModuleNameFromID;
import static database.ProgrammingLanguageDBHandler.getLanguageNameFromID;
import static database.ScoreAndPerfDBHandler.getEverythingFromScores;
import static database.ScoreAndPerfDBHandler.getPerformanceOfUser;
import static database.UserDBHandler.getUserByUsername;
import static database.UserDBHandler.getUserIDByUsername;

public class UserMainScreenController {

    @FXML public Button AccountDetails, GoToModules, ScoresAndPerformance, LogOutButton;
    String username;
    MyAccountPageController myAccountPageController;
    LanguagePickerController languagePickerController;
    ScoresAndPerformanceController scoresAndPerformanceController;
    WizardDoneController wizardDoneController;

    @FXML public void initialize() {
        myAccountPageController = new MyAccountPageController();
        languagePickerController = new LanguagePickerController();
        scoresAndPerformanceController = new ScoresAndPerformanceController();
        wizardDoneController = new WizardDoneController();
    }

    @FXML public void GoToModules(ActionEvent actionEvent) {
        Stage loginStage = (Stage) GoToModules.getScene().getWindow();
        loginStage.close();

        System.out.println("Go to Modules");
        try {

            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/LanguagePickerUI.fxml"));
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            Parent root = loader.load();

            languagePickerController = loader.getController();

            Stage stage = new Stage();
            stage.setResizable(false);

            stage.getIcons().add(img);

            stage.setTitle("Code Learner");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnCloseRequest(event -> System.exit(0));

            languagePickerController.setUsername(getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void ScoresAndPerformance(ActionEvent actionEvent) throws SQLException {

        System.out.println("S&P username: " + getUsername());
        System.out.println("Scores & Performance");


        int userId = getUserIDByUsername(getUsername());
        double performance = getPerformanceOfUser(userId);
        System.out.println("userId: " + userId);
        User user = getUserByUsername(getUsername());

        String moduleName, programmingLanguage;
        int moduleId, programming_language_ID, numberOfCorrectAnswers, numberOfIncorrectAnswers, totalNumberOfAnswers;
        double score;

        ArrayList<Report> report = new ArrayList<>();
        ResultSet resultSet = getEverythingFromScores(userId);
        String finalString = null;

        while (resultSet.next()) {
            moduleId = resultSet.getInt("moduleID");
            programming_language_ID = resultSet.getInt("programming_language_ID");
            score = resultSet.getDouble("score");
            numberOfCorrectAnswers = resultSet.getInt("numberOfCorrectAnswers");
            totalNumberOfAnswers = resultSet.getInt("totalNumberOfAnswers");

            moduleName = getModuleNameFromID(moduleId);
            programmingLanguage = getLanguageNameFromID(programming_language_ID);

            System.out.println("moduleName: " + moduleName);
            System.out.println("programmingLanguage: " + programmingLanguage);
            System.out.println("score: " + score);
            System.out.println("numberOfCorrectAnswers: " + numberOfCorrectAnswers);
            System.out.println("totalNumberOfAnswers: " + totalNumberOfAnswers);

            report.add(new Report(moduleName, programmingLanguage, score, numberOfCorrectAnswers, totalNumberOfAnswers));
        }

        StringBuilder builder = new StringBuilder();
        for (Report value : report)  builder.append(value);
        String text = builder.toString();

        Stage loginStage = (Stage) ScoresAndPerformance.getScene().getWindow();
        loginStage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ScoresAndPerformanceUI.fxml"));
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            Parent root = loader.load();

            scoresAndPerformanceController = loader.getController();

            Stage stage = new Stage();
            stage.setResizable(false);

            stage.getIcons().add(img);

            stage.setTitle("Code Learner");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnCloseRequest(event -> System.exit(0));

            System.out.println("S&P username: " + getUsername());
            scoresAndPerformanceController.setUsername(getUsername());
            scoresAndPerformanceController.textArea.setText("MODULES: \n\n" + text);
            scoresAndPerformanceController.performance.setText("PERFORMANCE: " + performance + "%");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void GoToMyAccount(ActionEvent actionEvent) throws SQLException {

        User user = getUserByUsername(getUsername());
        System.out.println("User: " + user);
        Stage stage = (Stage) AccountDetails.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MyAccountPageUI.fxml"));
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            Parent parent = loader.load();

            myAccountPageController = loader.getController();

            stage = new Stage();
            stage.setResizable(false);

            stage.getIcons().add(img);

            stage.setTitle("Code Learner");
            stage.setScene(new Scene(parent));
            stage.show();
            stage.setOnCloseRequest(event -> System.exit(0));

            myAccountPageController.firstName.setText(user.getFirstName());
            myAccountPageController.lastName.setText(user.getLastName());
            myAccountPageController.setUsername(getUsername());
            myAccountPageController.username.setText(getUsername());
            myAccountPageController.email.setText(user.getEmail());
            myAccountPageController.accountOpenDate.setText(String.valueOf(user.getAccountOpen()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML public void Logout(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/LoginScreenUI.fxml", LogOutButton);
    }

    public final void setUsername(String name) {
        this.username = name;
        System.out.println("(set) assign Username to string variable: " + username);
    }

    public final String getUsername() {
        System.out.println("(get) username: " + username);
        return username;
    }
}
