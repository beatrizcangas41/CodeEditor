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
import javafx.scene.image.Image;
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
    String username, password;

    UserMainScreenController userMainScreenController;

    @FXML public void initialize() {
        UserDBHandler userDBHandler = new UserDBHandler();
    }

    @FXML public void loginButtonPressed() throws IOException {

        try {
            if (userExists(getUsername())) {
                if (!verifyLoginCredentials(getUsername(), getPassword()))
                    displayErrorDialog("Error", "Input not valid", "Wrong Username or Password");
                else {
                    String user_type = getUserTypeFromUsername(getUsername());

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
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            Parent parent = loader.load();

            accountRegisterController = loader.getController();

            stage = new Stage();
            stage.setResizable(false);

            stage.getIcons().add(img);

            stage.setTitle("Code Learner");
            stage.setScene(new Scene(parent));
            stage.show();
            stage.setOnCloseRequest(event -> System.exit(0));
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void setUsername(String name) {
        this.username = name;
        System.out.println("(set) assign Username to string variable: " + username);
    }

    public final String getUsername() {
        username = usernameTextField.getText();
        System.out.println("(get) username: " + username);
        return username;
    }

    public final void setPassword(String pwrd) {
        this.password = pwrd;
        System.out.println("(set) assign Password to string variable: " + password);
    }

    public final String getPassword() {
        password = passwordField.getText();
        System.out.println("(get) password: " + password);
        return password;
    }
}