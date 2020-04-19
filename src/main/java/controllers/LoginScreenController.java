package controllers;

import database.UserDBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.SceneChange;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static database.UserDBHandler.*;
import static util.DialogCreator.displayErrorDialog;

public class LoginScreenController {

    @FXML private Button registerButton, loginButtonPressed, forgotPassword;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordField;
    @FXML private Label lblFromController2;

    AccountRegisterController accountRegisterController;

    @FXML public void initialize() {
        UserDBHandler userDBHandler = new UserDBHandler();
       // userMainScreenController = new UserMainScreenController();
    }

    @FXML public void loginButtonPressed() throws IOException {

        String uName = usernameTextField.getText();
        String pwrd = passwordField.getText();


        try {
            if (userExists(uName)) {
                if (!verifyLoginCredentials(uName, pwrd))
                    displayErrorDialog("Error", "Input not valid", "Wrong Username or Password");
                else {
                    String user_type = getUserTypeFromUsername(uName);

                    if (user_type.equals("Admin")) {
                        System.out.println("Admin Page");

                        Stage stage = (Stage) loginButtonPressed.getScene().getWindow();
                        stage.close();

                        Parent page = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/AdminMainScreenUI.fxml")));
                        Scene scene = new Scene(page, 800, 500);
                        Stage newStage = new Stage();
                        newStage.setTitle("Code Learner");

                        newStage.setScene(scene);
                        newStage.show();

                        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/AdminMainScreenUI.fxml"));
                        Parent root = loader.load();


                    } else if (user_type.equals("User")) {

                        Stage loginStage = (Stage) passwordField.getScene().getWindow();
                        loginStage.close();

                        System.out.println("User Page");

                        //Load second scene
                        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/UserMainScreenUI.fxml"));
                        Parent root = loader.load();

                        Object userMainScreenController = loader.getController();
                        // userMainScreenController.setName(uName);

                        //Show scene 2 in new window
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        // stage.setScene(new Scene(root, 1200, 800));
                        stage.setTitle("Code Learner");
                        stage.show();
                    }

                    else displayErrorDialog("Error", "Error", "The user has not been classified ");
                }
            }
            else displayErrorDialog("Error", "user does not exist", "please try again");

        } catch (SQLException e) {
            displayErrorDialog("Error", "SQL Error", "Unable to verify credentials");
        }
    }

    @FXML public void forgotPassword(ActionEvent actionEvent) {

        System.out.println("The account page has been loaded");
        SceneChange.sceneChangeButton("fxml/ForgotPasswordUI.fxml", forgotPassword);
    }

    @FXML public void registerButton(ActionEvent actionEvent) {

        System.out.println("The account page has been loaded");
        Stage stage = (Stage) registerButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/AccountRegisterUI.fxml"));
            Parent parent = loader.load();

            accountRegisterController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}