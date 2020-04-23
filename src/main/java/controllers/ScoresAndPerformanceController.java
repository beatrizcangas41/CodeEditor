package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import util.SceneChange;

public class ScoresAndPerformanceController {


    @FXML public Button backButton;

    @FXML
    public void goBack(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
    }
}
