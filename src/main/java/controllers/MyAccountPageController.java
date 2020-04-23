package controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.SceneChange;

public class MyAccountPageController {
    public Button confirmEmail;
    public Button confirmPassword;
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
    public Button backButton;


    @FXML public void confirm(ActionEvent actionEvent) {
    }

    @FXML public void confirmEmail(Event event) {
    }

    @FXML public void confirmPassword(ActionEvent actionEvent) {

    }

    @FXML public void goBack(ActionEvent actionEvent) {
        SceneChange.sceneChangeButton("fxml/UserMainScreenUI.fxml", backButton);
    }

}
