package controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WizardStartController {
    @FXML public TextField moduleName;
    @FXML public Button finishButton;
    @FXML public Button backButton;
    @FXML public Button nextButton;

    ModulePickerController modulePickerController;


    @FXML
    public void initialize() {
        System.out.println("initializing");
        modulePickerController = new ModulePickerController();
    }

    public String getModuleName() {
        return moduleName.getText();
    }

    public void setModuleName(String name) {
        System.out.println("string passed: " + name);
        moduleName.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-text-inner-color: #3BB2B8");

        if (name.equals("Hello World!, Line & Block Comments")) moduleName.setAlignment(Pos.CENTER_LEFT);
        else moduleName.setAlignment(Pos.CENTER);

        moduleName.setText(name);
        System.out.println("text field: " + getModuleName());
    }
}
