package controllers;

import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Wizard1Controller extends AbstractWizardController {

    @FXML
    @LinkAction(Wizard2Controller.class)
    private Button nextButton;
}

