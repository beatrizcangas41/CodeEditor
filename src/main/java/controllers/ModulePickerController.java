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

import static database.ModuleDBHandler.getModuleFromNumber;

public class ModulePickerController {

    private String moduleName;
    WizardStartController controller;
    @FXML
    private Button Module1Button, Module2Button, Module3Button, Module4Button,
            Module5Button, Module6Button, Module7Button, backButton;

    @FXML public void initialize() throws SQLException {
        setButtonText();
    }

    public void setButtonText() throws SQLException {
        Module1Button.setText(getModuleFromNumber(1));
        Module2Button.setText(getModuleFromNumber(2));
        Module3Button.setText(getModuleFromNumber(3));
        Module4Button.setText(getModuleFromNumber(4));
        Module5Button.setText(getModuleFromNumber(5));
        Module6Button.setText(getModuleFromNumber(6));
        Module7Button.setText(getModuleFromNumber(7));
    }

    public final void setModuleName(String name) {

        this.moduleName = name;
        // moduleName = Module1Button.getText();
        System.out.println(" (set) assign Module Name to string variable: " + moduleName);
    }

    public final String getModuleName() {
        System.out.println(" (get) Module Name: " + moduleName);
        return moduleName;
    }

    @FXML
    public void goBack(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
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

            controller = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            controller.setModuleName(getModuleName());
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

            controller = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            controller.setModuleName(getModuleName());
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

            controller = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            controller.setModuleName(getModuleName());
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

            controller = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            controller.setModuleName(getModuleName());
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

            controller = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            controller.setModuleName(getModuleName());
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

            controller = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            controller.setModuleName(getModuleName());
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

            controller = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            controller.setModuleName(getModuleName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

