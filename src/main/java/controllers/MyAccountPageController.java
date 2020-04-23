package controllers;

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
import util.SceneChange;

import java.io.IOException;
import java.util.Objects;

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

    @FXML public void confirmEmail(ActionEvent actionEvent) {

    }

    @FXML public void confirmPassword(ActionEvent actionEvent) {

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
}
