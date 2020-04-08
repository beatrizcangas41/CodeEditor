package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WizardDoneController {

    @FXML
    private Button backButton, nextButton, finishButton;

    @FXML
    public void init() {
        nextButton.setDisable(true);
    }
}
