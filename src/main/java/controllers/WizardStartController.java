package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WizardStartController {

    @FXML private Button backButton, nextButton, finishButton;
    @FXML public static TextField moduleNameLabel;

    // private static ArrayList<Module> modules;
    // private static ArrayList<Question> questions;


    void setModuleName(String moduleName) {
        moduleName.replace("\"", "");
        System.out.println("MN: " + moduleName);
        moduleNameLabel.setText("test");
    }

    /*
    public void setModuleName() {
        moduleNameLabel.setPromptText(ModulePickerController.getModuleName());
        //moduleNameLabel.setText(ModulePickerController.getModuleName());
        System.out.println("Module Name* : " + moduleNameLabel.getText());
    } */

    String getModuleName() {
        return moduleNameLabel.getText();
    }

}
