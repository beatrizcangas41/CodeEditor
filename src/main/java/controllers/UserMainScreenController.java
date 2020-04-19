package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import util.SceneChange;

public class UserMainScreenController {

    @FXML public Button MyAccountButton, MyScoresButton, ModulesButton, MyPerformanceButton, LogOutButton;

    @FXML public void GoToMyAccount(ActionEvent actionEvent) {
        // SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
    }

    @FXML public void GoToScores(ActionEvent actionEvent) {
        // SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
    }

    @FXML public void GoToModules(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/LanguagePickerUI.fxml", ModulesButton);
    }

    @FXML public void GoToPerformance(ActionEvent actionEvent) {
        // SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
    }

    @FXML public void Logout(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/LoginScreenUI.fxml", LogOutButton);
    }
}
