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

import static database.Question_Module_Performance_DatabaseHandler.*;

public class ModulePickerController {

    private WizardStartController wizardStartController;
    private String moduleName;

    @FXML
    private Button Module1Button, Module2Button, Module3Button, Module4Button,
            Module5Button, Module6Button, Module7Button, Module8Button,
            backButton;

    private WizardStartController WizardStartController;

    @FXML public void initialize() {
        WizardStartController = new WizardStartController();
    }

    public final void setModuleName(int moduleNumber) throws SQLException {

        moduleName = getModuleFromNumber(moduleNumber);
        // moduleName = Module1Button.getText();
        System.out.println(" (set) Module Name: " + moduleName);
    }

    public final String getModuleName() {
        System.out.println(" (get) Module Name: " + moduleName);
        moduleName.replace("\"", "");
        return moduleName;
    }

    @FXML
    public void goBack(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
    }

    @FXML public void Module1(ActionEvent actionEvent) throws SQLException {

        // setModuleName(Module1Button.getText());
        // System.out.println("Name: " + moduleName);

        setModuleName(1);

        Stage stage = (Stage) Module1Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            WizardStartController.setModuleName(moduleName);
            WizardStartController = loader.getController();


            System.out.println("module name: " + moduleName);

            Scene newScene = new Scene(parent);
            Stage newStage = new Stage();
            newStage.setTitle("Code Learner");
            newStage.setScene(newScene);
            newStage.showAndWait();
        }

        catch (IOException ioEx) {
            ioEx.printStackTrace();


        }
    }

    @FXML public void Module2(ActionEvent actionEvent) {

        // moduleName = Module2Button.getText();
        System.out.println("Name: " + moduleName);

        Stage stage = (Stage) Module2Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardStartUI.fxml"));
            Parent parent = loader.load();

            Scene newScene = new Scene(parent);
            Stage newStage = new Stage();

            newStage.setTitle("Code Learner");
            newStage.setScene(newScene);
            newStage.show();

            // wizardStartController = loader.getController();
            // wizardStartController.setModuleName(moduleName);
        }

        catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    @FXML public void Module3(ActionEvent actionEvent) {

    }

    @FXML public void Module4(ActionEvent actionEvent) {

    }

    @FXML public void Module5(ActionEvent actionEvent) {

    }

    @FXML public void Module6(ActionEvent actionEvent) {

    }

    @FXML public void Module7(ActionEvent actionEvent) {

    }

    @FXML public void Module8(ActionEvent actionEvent) {

    }

}

