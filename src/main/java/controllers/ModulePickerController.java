package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import util.SceneChange;

import java.io.IOException;
import java.sql.SQLException;

import static database.ModuleDBHandler.getModuleFromLanguageAndNumber;
import static database.ModuleDBHandler.getModuleFromNumber;

public class ModulePickerController {

    private String moduleName, languageName;

    WizardStartController wizardStartController;
    LanguagePickerController languagePickerController;

    @FXML private Button Module1Button, Module2Button, Module3Button, Module4Button,
            Module5Button, Module6Button, Module7Button, Module8Button, backButton;

    @FXML public void initialize() throws SQLException {
        System.out.println("initializing");
        languagePickerController = new LanguagePickerController();
    }

    public void setButtonText(String languageName) throws SQLException {
        if (getModuleFromLanguageAndNumber(1, languageName) != null) Module1Button.setText(getModuleFromNumber(1));
        if (Module1Button.getText().contains("Module 1")) {
            Module1Button.setDisable(true);
            Module1Button.setText("");
        }

        if (getModuleFromLanguageAndNumber(2, languageName) != null) Module2Button.setText(getModuleFromNumber(2));
        if (Module2Button.getText().contains("Module 2")) {
            Module2Button.setDisable(true);
            Module2Button.setText("");
        }

        if (getModuleFromLanguageAndNumber(3, languageName) != null) Module3Button.setText(getModuleFromNumber(3));
        if (Module3Button.getText().contains("Module 3")) {
            Module3Button.setDisable(true);
            Module3Button.setText("");
        }

        if (getModuleFromLanguageAndNumber(4, languageName) != null) Module4Button.setText(getModuleFromNumber(4));
        if (Module4Button.getText().contains("Module 4")) {
            Module4Button.setDisable(true);
            Module4Button.setText("");
        }

        if (getModuleFromLanguageAndNumber(5, languageName) != null) Module5Button.setText(getModuleFromNumber(5));
        if (Module5Button.getText().contains("Module 5")) {
            Module5Button.setDisable(true);
            Module5Button.setText("");
        }

        if (getModuleFromLanguageAndNumber(6, languageName) != null) Module6Button.setText(getModuleFromNumber(6));
        if (Module6Button.getText().contains("Module 6")) {
            Module6Button.setDisable(true);
            Module6Button.setText("");
        }

        if (getModuleFromLanguageAndNumber(7, languageName) != null) Module7Button.setText(getModuleFromNumber(7));
        if (Module7Button.getText().contains("Module 7")) {
            Module7Button.setDisable(true);
            Module7Button.setText("");
        }

        if (getModuleFromLanguageAndNumber(8, languageName) != null) Module8Button.setText(getModuleFromNumber(8));
        if (Module8Button.getText().contains("Module 8")) {
            Module8Button.setDisable(true);
            Module8Button.setText("");
        }
    }

    public String getLanguageName() {
        System.out.println("MPC - (get) Language Name: " + languageName);
        return languageName;
    }

    public void setLanguageName(String name) {
        System.out.println("string passed: " + name);
        // languageName = name;
        this.languageName = name;
        System.out.println(" (set) assign Language Name to string variable: " + languageName);
    }

    public final void setModuleName(String name) throws SQLException {
        this.moduleName = name;
        System.out.println(" (set) assign Module Name to string variable: " + moduleName);
    }

    public final String getModuleName() {
        System.out.println("(get) Module Name: " + moduleName);
        return moduleName;
    }

    @FXML public void goBack(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/LanguagePickerUI.fxml", backButton);
    }

    @FXML public void Module1(ActionEvent actionEvent) {

        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        moduleName = buttonText;

        System.out.println("module name: " + moduleName);
        getModuleName();

        Stage stage = (Stage) Module1Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            wizardStartController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            wizardStartController.setModuleName(getModuleName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void Module2(ActionEvent actionEvent) {

        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        moduleName = buttonText;

        System.out.println("module name: " + moduleName);
        getModuleName();

        Stage stage = (Stage) Module2Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            wizardStartController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            wizardStartController.setModuleName(getModuleName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void Module3(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        moduleName = buttonText;

        System.out.println("module name: " + moduleName);
        getModuleName();

        Stage stage = (Stage) Module3Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            wizardStartController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            wizardStartController.setModuleName(getModuleName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void Module4(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        moduleName = buttonText;

        System.out.println("module name: " + moduleName);
        getModuleName();

        Stage stage = (Stage) Module4Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            wizardStartController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            wizardStartController.setModuleName(getModuleName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void Module5(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        moduleName = buttonText;

        System.out.println("module name: " + moduleName);
        getModuleName();

        Stage stage = (Stage) Module5Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            wizardStartController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            wizardStartController.setModuleName(getModuleName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void Module6(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        moduleName = buttonText;

        System.out.println("module name: " + moduleName);
        getModuleName();

        Stage stage = (Stage) Module6Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            wizardStartController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            wizardStartController.setModuleName(getModuleName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void Module7(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        moduleName = buttonText;

        System.out.println("module name: " + moduleName);
        getModuleName();

        Stage stage = (Stage) Module7Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            wizardStartController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            wizardStartController.setModuleName(getModuleName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void Module8(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        moduleName = buttonText;

        System.out.println("module name: " + moduleName);
        getModuleName();

        Stage stage = (Stage) Module8Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            wizardStartController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            wizardStartController.setModuleName(getModuleName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

