
package controllers;

import database.DatabaseConnector;
import database.UserDBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.DialogCreator;
import util.SceneChange;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static database.UserDBHandler.*;
import static util.DialogCreator.displayErrorDialog;
import static util.EmailValidator.emailValidator;

public class AccountRegisterController {

    private UserDBHandler userDBHandler;

    @FXML private Button createAccountPressed, cancelButtonPressed;
    @FXML private TextField nameTextField1, nameTextField2, emailTextField1,
                            emailTextField2, usernameTextField1;
    @FXML private PasswordField passwordField1, passwordField2;

    String firstName, lastName, email1, email2, uName1, pwrd1, pwrd2;

    @FXML public void initialize() {
        LoginScreenController loginScreenController = new LoginScreenController();
    }

    @FXML public void createAccountPressed() throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        Statement stmt2 = null;

        if (connection != null) {
            System.out.println("Connection Successful");

            if(!hasErrors()) {
                addUser(firstName, lastName, email1, uName1, pwrd1);
                System.out.println("Entered credentials : " + uName1 + " " + email1 + " " + firstName + " " + lastName + " " + pwrd1);

                Stage loginStage = (Stage) createAccountPressed.getScene().getWindow();
                loginStage.close();

                System.out.println("User Page");

                SceneChange.sceneChangeButton("fxml/LoginScreenUI.fxml", createAccountPressed);
            }

        }

        else {
            System.out.println("Connection Fails");
            String message = "Failed to Connect. Please try again. ";
            DialogCreator.displayErrorDialog("Error", "Connection Error", message);
        }
    }

    @FXML public void cancelButtonPressed(ActionEvent actionEvent) {

        System.out.println("Cancel Button Pressed");
        SceneChange.sceneChangeButton("fxml/LoginScreenUI.fxml", cancelButtonPressed);
    }

    private boolean hasErrors() throws SQLException {

        firstName = nameTextField1.getText();
        lastName = nameTextField2.getText();
        email1 = emailTextField1.getText();
        email2 = emailTextField2.getText();
        uName1 = usernameTextField1.getText();
        pwrd1 = passwordField1.getText();
        pwrd2 = passwordField2.getText();

        boolean hasErrors = false;
        String errorMessage = "Please address the following error(s) before test can be run: \n";

        if (firstName.isEmpty() || lastName.isEmpty() || email1.isEmpty() || email2.isEmpty() || uName1.isEmpty() || pwrd1.isEmpty() || pwrd2.isEmpty()) {
            errorMessage += "\n    - Please verify your input(s), they may be empty. ";
            hasErrors = true;
        }

        if (userExists(uName1)) {
            errorMessage += "\n    - Username is already taken. ";
            hasErrors = true;
        }

        if (verifyEmail(uName1, email1)) {
            errorMessage += "\n    - Email is already taken. ";
            hasErrors = true;
        }

        if (!email1.equals(email2)) {
            errorMessage += "\n    - Email address is not a match.";
            hasErrors = true;
        }

        if (!emailValidator(email1)) {
            errorMessage += "\n    - Invalid email, wrong format.";
            hasErrors = true;
        }

        if (!pwrd1.equals(pwrd2)) {
            errorMessage += "\n    - Password is not a match. Please try again. ";
            hasErrors = true;
        }

        if (pwrd1.length() < 8) {
            System.out.println("pwrd1 length: " + pwrd1.length());
            errorMessage += "\n    - Password must be at least 8 characters long. Please try again.  ";
            hasErrors = true;
        }

        if (hasErrors) displayErrorDialog("Error", "Unable to Create your Account", errorMessage);
        return hasErrors;
    }

}