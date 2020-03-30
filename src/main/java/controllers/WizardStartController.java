package controllers;

import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.annotation.PostConstruct;

public class WizardStartController extends AbstractWizardController {

    @FXML
    @LinkAction(Wizard1Controller.class)
    private Button nextButton;

    @PostConstruct
    public void init() {
        getBackButton().setDisable(true);
    }
}
