package controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MyAccountPageController {
    public Button confirmEmail, confirmPassword, backButton;
    public TextField username;
    public TextField firstName;
    public TextField lastName;
    public TextField email;
    public TextField accountOpenDate;

    public PasswordField password1;
    public PasswordField password2;
    public PasswordField currentPassword;

    public TextField email1;
    public TextField email2;
    public TextField currentEmail;

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

    @FXML public void confirm(ActionEvent actionEvent) {
    }

    @FXML public void confirmEmail(Event event) {
    }

    @FXML public void confirmPassword(ActionEvent actionEvent) {

    }

    @FXML public void goBack(ActionEvent actionEvent) {
        Stage loginStage = (Stage) backButton.getScene().getWindow();
        loginStage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/UserMainScreenUI.fxml"));
            Parent root = loader.load();

            userMainScreenController = loader.getController();

            //Show scene 2 in new window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Code Learner");
            stage.show();

            userMainScreenController.setUsername(getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
