package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import util.SceneChange;

import java.io.IOException;
import java.util.Objects;

public class WizardDoneController {

    @FXML TextArea questionDescription;
    @FXML Button finishButton;

    String username;
    WizardController wizardController;
    UserMainScreenController userMainScreenController;

    @FXML public void initialize() {
        wizardController = new WizardController();
        System.out.println("Initializing WizardDoneController");
    }

    @FXML public void setText(String text) {
        questionDescription.setText(text);
    }

    @FXML public void finishButton(ActionEvent actionEvent) {
        Stage stage = (Stage) finishButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/UserMainScreenUI.fxml"));
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            Parent parent = loader.load();

            userMainScreenController = loader.getController();

            stage = new Stage();
            stage.setResizable(false);

            stage.getIcons().add(img);

            stage.setTitle("Code Learner");
            stage.setScene(new Scene(parent));
            stage.show();
            stage.setOnCloseRequest(event -> System.exit(0));

            userMainScreenController.setUsername(getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        }    }

    public final void setUsername(String name) {
        this.username = name;
        System.out.println("(set) assign Username to string variable: " + username);
    }

    public final String getUsername() {
        System.out.println("(get) username: " + username);
        return username;
    }
}
