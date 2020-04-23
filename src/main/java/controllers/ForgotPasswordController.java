package controllers;

import database.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.SceneChange;

import java.sql.*;

import static database.UserDBHandler.addToken;
import static database.UserDBHandler.verifyUsernameAndEmail;
import static util.DialogCreator.displayErrorDialog;
import static util.DialogCreator.displayInformationDialog;
import static util.EmailValidator.emailValidator;
import static util.JavaMail.getToken;
import static util.JavaMail.sendMail;

public class ForgotPasswordController {

    @FXML public Button confirmEmail, goBackButton, loginButtonPressed;
    @FXML public TextField  uName, email1, email2;
    @FXML public PasswordField passwordField;
    @FXML public Button registerButton, forgotPassword;

    String username1, emailEntered1,emailEntered2;

    @FXML public void confirmEmail(ActionEvent actionEvent) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();
        Statement stmt = null;

        if (conn != null) {
            System.out.println("Connection was Successful");

            if (!hasErrors()) {

                System.out.println("Printing : " + username1 + " " + emailEntered1);

                try {
                    String uuid = getToken();
                    System.out.println("token: " + uuid);

                    if (!addToken(uuid, username1)) {
                        System.out.println("The token was added in the database. ");

                        if (emailValidator(emailEntered1)) {
                            Thread.sleep(2000);
                            System.out.print("The Email address " + emailEntered1 + " is valid");
                            sendMail(emailEntered1);

                            System.out.println("The email was sent. ");

                            boolean flag = true;
                            while(flag) {
                                String query2 = "SELECT * FROM user WHERE token = '" + uuid + "'";
                                PreparedStatement pstmt = conn.prepareStatement(query2);
                                ResultSet results2 = pstmt.executeQuery(query2);

                                String token2 = null;
                                while (results2.next()) token2 = results2.getString("token");
                                if (token2 != null) flag = false;
                            }

                            System.out.println("token: " + uuid);

                            displayInformationDialog("Confirmation", "Email Successfully Sent",
                                    "Please use the token to reset your password");
                            System.out.println("Confirmation Displayed");

                            SceneChange.sceneChangeButton("fxml/PasswordResetUI.fxml", confirmEmail);
                        }

                        else {
                            System.out.print("The Email address " + emailEntered1 + " isn't valid");

                            displayErrorDialog("Error", "Invalid Email Address",
                                    "Please try registering again or Contact Us, our email is OwlLibraryBookstore@gmail.com" +
                                            " and don't forget to include your username in the email. ");
                        }

                    } else System.out.println("The token could not be added. Something failed");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        else {
            String message = "Failed to Connect. Please try again. ";
            displayErrorDialog("Error", "Connection Error", message);
        }
    }

    @FXML void goBackButton(ActionEvent actionEvent) {
        System.out.println("Go Back Button Pressed");
        SceneChange.sceneChangeButton("fxml/loginScreenUI.fxml", goBackButton);
    }

    private boolean hasErrors() throws SQLException {

        username1 = uName.getText();
        emailEntered1 = email1.getText();
        emailEntered2 = email2.getText();

        boolean hasErrors = false;
        String errorMessage = "Please address the following error(s) before test can be run: \n";

        if (username1.isEmpty() || emailEntered1.isEmpty() || emailEntered2.isEmpty()) {
            System.out.println("missing credentials");

            errorMessage += "\n    - Please verify your input(s), something is missing. ";
            hasErrors = true;
        }

        if (!emailEntered1.equals(emailEntered2)) {
            errorMessage += "\n    - Email address is not a match. ";
            hasErrors = true;
        }

        if (!emailValidator(emailEntered1)) {
            errorMessage += "\n    - Invalid email, wrong format.";
            hasErrors = true;
        }

        ResultSet results3 = verifyUsernameAndEmail(username1, emailEntered1);
        if (!results3.next()) {
            errorMessage += "\n    - Wrong Credentials. Either your Username or Email is Incorrect ";
            hasErrors = true;
        }

        if (hasErrors) displayErrorDialog("Error", "Unable to Create your Account", errorMessage);
        return hasErrors;
    }
}
