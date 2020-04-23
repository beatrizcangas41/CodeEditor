package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.User;
import util.SceneChange;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static database.UserDBHandler.getUserByUsername;

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

        System.out.println("User Page");
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

    @FXML public void ScoresAndPerformance(ActionEvent actionEvent) {
        Stage loginStage = (Stage) ScoresAndPerformance.getScene().getWindow();
        loginStage.close();

        System.out.println("User Page");
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

            scoresAndPerformanceController.setUsername(getUsername());
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
