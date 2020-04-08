package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import util.SceneChange;

import javax.annotation.PostConstruct;

public class Wizard6Controller {

    @FXML
    private Button nextButton, backButton, finishButton;

    @PostConstruct
    public void init() {
        finishButton.setDisable(true);
    }

    public void setNextButton(ActionEvent actionEvent) {

        System.out.println("Cancel Button Pressed");
        SceneChange.sceneChangeButton("fxml/LoginScreenUI.fxml", nextButton);
    }
}