package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.annotation.PostConstruct;

public class WizardDoneController extends AbstractWizardController {

    @FXML
    private Button nextButton;

    @PostConstruct
    public void init() {
        nextButton.setDisable(true);
        getFinishButton().setDisable(true);
    }
}
