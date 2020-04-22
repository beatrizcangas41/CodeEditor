package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;
import util.DialogCreator;
import util.SceneChange;

import java.io.IOException;
import java.sql.SQLException;

public class LanguagePickerController {

    @FXML public Button backButton, C_PlusPlus_Button, Java_Button, JavaScript_Button,
            SQL_Button, Swift_Button, ObjectiveC_Button, Ruby_Button, Python_Button;

    ModulePickerController modulePickerController;

    private String languageName, username;

    public final void setLanguageName(String name) {

        this.languageName = name;
        // moduleName = Module1Button.getText();
        System.out.println("(set) assign Language Name to string variable: " + languageName);
    }

    public final String getLanguageName() {
        System.out.println("LPC - (get) Language Name: " + languageName);
        return languageName;
    }

    public final void setUsername(String name) {
        this.username = name;
        System.out.println("(set) assign Username to string variable: " + username);
    }

    public final String getUsername() {
        System.out.println("(get) username: " + username);
        return username;
    }

    public void C_PlusPlus(ActionEvent actionEvent) throws SQLException {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);

        setLanguageName(buttonText);
        System.out.println("module name: " + languageName);

        Stage stage = (Stage) C_PlusPlus_Button.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ModulePickerUI.fxml"));
            Parent parent = loader.load();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            modulePickerController = loader.getController();
            System.out.println("Setting Language Name in Module Picker: " + languageName);
            modulePickerController.setLanguageName(getLanguageName());
            modulePickerController.setButtonText(getLanguageName());
            modulePickerController.setUsername(getUsername());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Java(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        languageName = buttonText;

        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void JavaScript(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        languageName = buttonText;

        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void SQL(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        languageName = buttonText;

        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void Swift(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        languageName = buttonText;

        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void ObjectiveC(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        languageName = buttonText;

        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void Ruby(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        languageName = buttonText;

        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void Python(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        languageName = buttonText;

        DialogCreator.displayErrorDialog("Section Unavailable", "Section Under Development" , "Please try again");
    }

    public void goBack(ActionEvent actionEvent) {
        String buttonText = ((Button)actionEvent.getSource()).getText();
        System.out.println("Button text : " + buttonText);
        languageName = buttonText;

        SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
    }
}
