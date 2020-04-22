package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import util.SceneChange;

public class WizardDoneController {

    @FXML
    TextArea questionDescription;
    @FXML
    Button finishButton;
    WizardController wizardController;

    @FXML
    public void initialize() {
        wizardController = new WizardController();
        System.out.println("Initializing WizardDoneController");
    }

    public void setText(String text) {
        questionDescription.setText(text);
    }

    @FXML
    public void finishButton(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", finishButton);
    }
}
