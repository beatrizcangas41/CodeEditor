package controllers;

import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Wizard2Controller {

    @FXML
    @LinkAction(Wizard3Controller.class)
    private Button nextButton;
}