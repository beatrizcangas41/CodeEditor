package controllers;

import database.UserDatabaseHandler;
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

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static database.UserDatabaseHandler.*;
import static util.dialogCreator.displayErrorDialog;

public class LoginScreenController {

    private UserDatabaseHandler userDatabaseHandler;
    private Object userMainScreenController;

    @FXML private Button registerButtonPressed, loginButtonPressed, forgotPasswordButtonPressed;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordField;
    @FXML private Label lblFromController2;

    @FXML public void initialize() {
        userDatabaseHandler = new UserDatabaseHandler();
       // userMainScreenController = new UserMainScreenController();
    }

    @FXML
    public void loginButtonPressed() throws IOException {

        String uName = usernameTextField.getText();
        String pwrd = passwordField.getText();


        try {
            if (userExists(uName)) {
                if (!verifyLoginCredentials(uName, pwrd))
                    displayErrorDialog("Input not valid", "Wrong Username or Password");
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

                        userMainScreenController = loader.getController();
                        // userMainScreenController.setName(uName);

                        //Show scene 2 in new window
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root, 1200, 800));
                        stage.setTitle("Code Learner");
                        stage.show();
                    }

                    else displayErrorDialog("Error", "The user has not been classified ");
                }
            }
            else displayErrorDialog("user does not exist", "please try again");

        } catch (SQLException e) {
            displayErrorDialog("SQL Error", "Unable to verify credentials");
        }
    }

    @FXML
    public void forgotPassword(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) loginButtonPressed.getScene().getWindow();
        stage.close();

        Parent page = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/ForgotPasswordUI.fxml")));
        Scene scene = new Scene(page, 800, 500);
        Stage newStage = new Stage();
        newStage.setTitle("Code Learner");

        newStage.setScene(scene);
        newStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ForgotPasswordUI.fxml"));
        Parent root = loader.load();

        /*
        System.out.println("The account page has been loaded");
        sceneChange.sceneChangeButton("fxml/ForgotPasswordUI.fxml", registerButtonPressed);
         */
    }

    @FXML
    public void registerButton(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) loginButtonPressed.getScene().getWindow();
        stage.close();

        Parent page = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/RegisterUI.fxml")));
        Scene scene = new Scene(page, 800, 500);
        Stage newStage = new Stage();
        newStage.setTitle("Code Learner");

        newStage.setScene(scene);
        newStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/RegisterUI.fxml"));
        Parent root = loader.load();

        /*
        System.out.println("The account page has been loaded");
        sceneChange.sceneChangeButton("fxml/AccountScreenUI.fxml", registerButtonPressed);
         */
    }
}