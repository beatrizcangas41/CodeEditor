package controllers;

import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Wizard3Controller extends AbstractWizardController {

    @FXML
    @LinkAction(WizardDoneController.class)
    private Button nextButton;
}