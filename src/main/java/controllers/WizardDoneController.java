package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class WizardDoneController {

    @FXML public TextArea questionDescription;
    @FXML private Button backButton, nextButton, finishButton;

    WizardController wizardController;

    @FXML public void initialize() {
        wizardController = new WizardController();
        System.out.println("Initializing WizardDoneController");
    }

    public void setText(String text) {
        questionDescription.setText(text);
    }
}
