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

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static util.DialogCreator.displayErrorDialog;
import static util.DialogCreator.displayInformationDialog;
import static util.SceneChange.sceneChangeButton;

public class PasswordResetController {
    @FXML public Button confirmPassword, cancelButton;
    @FXML private TextField token;
    @FXML private PasswordField password1, password2;

    String pw1, pw2, token1;

    @FXML public void confirmPassword(ActionEvent actionEvent) throws SQLException {
        Connection conn = DatabaseConnector.getConnection();

        if (conn != null) {

            if (!hasErrors()) {

                String query2 = "SELECT * FROM user WHERE token = '" + token1 + "'";
                PreparedStatement pstmt = conn.prepareStatement(query2);
                ResultSet results2 = pstmt.executeQuery(query2);

                String token2 = null;
                while (results2.next()) token2 = results2.getString("token");
                System.out.println("entered: " + token1);
                System.out.println("DBToken: " + token2);

                if (token2 != null && token2.equals(token1)) {

                    String hashpw = BCrypt.hashpw(pw1, BCrypt.gensalt());
                    System.out.println("hashed pw: " + hashpw);

                    System.lineSeparator().equals("tokens are a match. ");

                    String query = "UPDATE user SET password = ? where token = ?";
                    PreparedStatement pstmt1 = conn.prepareStatement(query);
                    pstmt1.setString(1, hashpw);
                    pstmt1.setString(2, token1);

                    if (!pstmt1.execute()) {

                        System.out.println("password updated");
                        displayInformationDialog("Password Updated.", "Confirmation", "Congratulations, your password has been updated successfully! ");

                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/LoginScreenUI.fxml"));
                            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
                            Parent root = loader.load();

                            Stage stage = new Stage();
                            stage.setResizable(false);

                            stage.getIcons().add(img);

                            stage.setTitle("Code Learner");
                            stage.setScene(new Scene(root));
                            stage.show();
                            stage.setOnCloseRequest(event -> System.exit(0));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        else {
            displayErrorDialog("Error", "Input not valid", "Verify your credentials. Please try again. ");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ForgotPasswordUI.fxml"));
                Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setResizable(false);

                stage.getIcons().add(img);

                stage.setTitle("Code Learner");
                stage.setScene(new Scene(root));
                stage.show();
                stage.setOnCloseRequest(event -> System.exit(0));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML public void cancelButton(ActionEvent actionEvent) {
        System.out.println("Go Back Button Pressed");

        sceneChangeButton("fxml/loginScreenUI.fxml", cancelButton);
    }

    public boolean hasErrors() {
        pw1 = password1.getText();
        pw2 = password2.getText();
        token1 = token.getText();

        boolean hasErrors = false;
        String errorMessage = "Please address the following error(s) before test can be run: \n";

        if (pw1 == null || pw2 == null || token1 == null) {
            errorMessage += "\n    - Please verify your input(s), they may be empty. ";
            hasErrors = true;
        }

        if (pw1!= null && !pw1.equals(pw2)) {
            errorMessage += "\n    - Password is not a match. Please try again. ";
            hasErrors = true;
        }

        if (pw1!= null && pw1.length() < 8) {
            System.out.println("pwrd1 length: " + pw1.length());
            errorMessage += "\n    - Password must be at least 8 characters long. Please try again.  ";
            hasErrors = true;
        }

        if (hasErrors) displayErrorDialog("Error", "Unable to Create your Account", errorMessage);
        return hasErrors;
    }
}
