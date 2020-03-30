package controllers;

import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Wizard2Controller extends AbstractWizardController {

    @FXML
    @LinkAction(Wizard3Controller.class)
    private Button nextButton;
}