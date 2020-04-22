package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.SceneChange;

import java.io.IOException;

public class UserMainScreenController {

    @FXML public Button MyAccountButton, MyScoresButton, ModulesButton, MyPerformanceButton, LogOutButton;
    String username;

    LanguagePickerController languagePickerController;

    @FXML public void GoToMyAccount(ActionEvent actionEvent) {
        // SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
    }

    @FXML public void GoToScores(ActionEvent actionEvent) {
        // SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
    }

    @FXML public void GoToModules(ActionEvent actionEvent) {
        Stage loginStage = (Stage) ModulesButton.getScene().getWindow();
        loginStage.close();

        System.out.println("User Page");
        try {

            //Load second scene
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/LanguagePickerUI.fxml"));
            Parent root = loader.load();

            languagePickerController = loader.getController();

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Code Learner");
            stage.show();

            languagePickerController.setUsername(getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void GoToPerformance(ActionEvent actionEvent) {
        // SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
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
