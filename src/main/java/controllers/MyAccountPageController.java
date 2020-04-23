package controllers;

import database.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.security.crypto.bcrypt.BCrypt;
import util.SceneChange;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

import static database.UserDBHandler.addToken;
import static database.UserDBHandler.verifyUsernameAndEmail;
import static util.DialogCreator.displayErrorDialog;
import static util.DialogCreator.displayInformationDialog;
import static util.EmailValidator.emailValidator;
import static util.JavaMail.getToken;
import static util.JavaMail.sendMail;

public class MyAccountPageController {
    public Button confirmEmail, confirmPassword, backButton;
    public TextField username;
    public TextField firstName;
    public TextField lastName;
    public TextField email;
    public TextField accountOpenDate;

    public PasswordField password1;
    public PasswordField password2;
    public TextField token;
    String getPasswordEntered1, getPasswordEntered2, getToken;

    public TextField email1;
    public TextField email2;
    public TextField currentEmail;
    String getEmailEntered1, getEmailEntered2, getCurrentEmail;


    String usernameString;
    UserMainScreenController userMainScreenController;

    @FXML public void initialize() {
        userMainScreenController = new UserMainScreenController();
    }

    public final void setUsername(String name) {
        this.usernameString = name;
        System.out.println("(set) assign Username to string variable: " + usernameString);
    }

    public final String getUsername() {
        System.out.println("(get) username: " + usernameString);
        return usernameString;
    }

    @FXML public void confirmEmail(ActionEvent actionEvent) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();
        Statement stmt = null;

        if (conn != null) {
            System.out.println("Connection was Successful");
            if (!hasErrors_EMAIL()) {
                String query = "UPDATE user SET email = ? where username = ?";
                PreparedStatement pstmt1 = conn.prepareStatement(query);
                pstmt1.setString(1, getEmailEntered1);
                pstmt1.setString(2, getUsername());

                if (!pstmt1.execute()) {
                    System.out.println("Email Updated");
                    email.setText(getEmailEntered1);
                    displayInformationDialog("Email Updated.", "Confirmation", "Congratulations, your email has been updated successfully! ");
                }
            }
        }

        else {
            displayErrorDialog("Error", "Something went wrong", "Could not Connect to Database. Please try again. ");
        }
    }

    @FXML public void confirmPassword(ActionEvent actionEvent) throws SQLException {

        Connection conn = DatabaseConnector.getConnection();

        if (conn != null) {

            if (!hasErrors_PASSWORD()) {

                String query2 = "SELECT * FROM user WHERE username = '" + getUsername() + "' AND token = '" + getToken + "'";
                PreparedStatement pstmt = conn.prepareStatement(query2);
                ResultSet results2 = pstmt.executeQuery(query2);

                String token2 = null;
                while (results2.next()) token2 = results2.getString("token");
                System.out.println("entered: " + getToken);
                System.out.println("DBToken: " + token2);

                if (token2 != null && token2.equals(getToken)) {

                    String hashpw = BCrypt.hashpw(getPasswordEntered1, BCrypt.gensalt());
                    System.out.println("hashed pw: " + hashpw);

                    System.lineSeparator().equals("tokens are a match. ");

                    String query = "UPDATE user SET password = ? where token = ?";
                    PreparedStatement pstmt1 = conn.prepareStatement(query);
                    pstmt1.setString(1, hashpw);
                    pstmt1.setString(2, getToken);

                    if (!pstmt1.execute()) {

                        System.out.println("password updated");
                        displayInformationDialog("Password Updated.", "Confirmation", "Congratulations, your password has been updated successfully! ");
                    }
                }

                else displayErrorDialog("Error", "Unable to reset your Password", "Something went wrong while attempting to update your password. Please try again.");
            }
        }

        else {
            displayErrorDialog("Error", "Something went wrong", "Could not Connect to Database. Please try again. ");
        }
    }

    @FXML public void goBack(ActionEvent actionEvent) {
        Stage loginStage = (Stage) backButton.getScene().getWindow();
        loginStage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/UserMainScreenUI.fxml"));
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            Parent root = loader.load();

            userMainScreenController = loader.getController();

            Stage stage = new Stage();
            stage.setResizable(false);

            stage.getIcons().add(img);

            stage.setTitle("Code Learner");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnCloseRequest(event -> System.exit(0));

            userMainScreenController.setUsername(getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void requestToken(ActionEvent actionEvent) throws SQLException, InterruptedException, MessagingException {
        Connection conn = DatabaseConnector.getConnection();
        Statement stmt = null;

        if (conn != null) {
            System.out.println("Connection was Successful");

            String uuid = getToken();
            System.out.println("token: " + uuid);

            if (!addToken(uuid, getUsername())) {
                System.out.println("The token was added in the database. ");

                if (emailValidator(email.getText())) {
                    Thread.sleep(2000);
                    System.out.print("The Email address " + email.getText() + " is valid");
                    sendMail(email.getText());

                    System.out.println("The email was sent. ");

                    boolean flag = true;
                    while (flag) {
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
                }
            }

        }
        else {
            String message = "Failed to Connect. Please try again. ";
            displayErrorDialog("Error", "Connection Error", message);
        }
    }

    private boolean hasErrors_EMAIL() throws SQLException {
        boolean hasErrors = false;
        String errorMessage = "Please address the following error(s) before test can be run: \n";

        getEmailEntered1 = email1.getText();
        getEmailEntered2 = email2.getText();
        getCurrentEmail = currentEmail.getText();

        ResultSet results3 = verifyUsernameAndEmail(getUsername(), getCurrentEmail);
        if (!results3.next()) {
            errorMessage += "\n    - Wrong Credentials. Either your Username or Email is Incorrect ";
            hasErrors = true;
        }

        if (getEmailEntered1.isEmpty() || getEmailEntered2.isEmpty() || getCurrentEmail.isEmpty()) {
            System.out.println("missing credentials");

            errorMessage += "\n    - Please verify your input(s), something is missing. ";
            hasErrors = true;
        }

        if (!emailValidator(getEmailEntered1)) {
            errorMessage += "\n    - Invalid email, wrong format.";
            hasErrors = true;
        }

        if (!getEmailEntered1.equals(getEmailEntered2)) {
            errorMessage += "\n    - Email address is not a match. ";
            hasErrors = true;
        }

        if (hasErrors) displayErrorDialog("Error", "Unable to Create your Account", errorMessage);
        return hasErrors;
    }

    private boolean hasErrors_PASSWORD() throws SQLException {
        boolean hasErrors = false;
        String errorMessage = "Please address the following error(s) before test can be run: \n";

        getPasswordEntered1 = password1.getText();
        getPasswordEntered2 = password2.getText();
        getToken = token.getText();

        if (getPasswordEntered1.isEmpty() || getPasswordEntered2.isEmpty() || getToken.isEmpty()) {
            System.out.println("missing credentials");

            errorMessage += "\n    - Please verify your input(s), something is missing. ";
            hasErrors = true;
        }

        if (!getPasswordEntered1.equals(getPasswordEntered2)) {
            errorMessage += "\n    - New Password is not a match. ";
            hasErrors = true;
        }

        if (getPasswordEntered1.length() < 8) {
            System.out.println("pwrd1 length: " + getPasswordEntered1.length());
            errorMessage += "\n    - Password must be at least 8 characters long. Please try again.  ";
            hasErrors = true;
        }

        if (hasErrors) displayErrorDialog("Error", "Unable to Create your Account", errorMessage);
        return hasErrors;
    }
}
