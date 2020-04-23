package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ScoresAndPerformanceController {

    @FXML public Button backButton;
    String username;

    UserMainScreenController userMainScreenController;

    @FXML public void initialize() {
        userMainScreenController = new UserMainScreenController();
    }

    @FXML
    public void goBack(ActionEvent actionEvent) {
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

    public final void setUsername(String name) {
        this.username = name;
        System.out.println("(set) assign Username to string variable: " + username);
    }

    public final String getUsername() {
        System.out.println("(get) username: " + username);
        return username;
    }
}
