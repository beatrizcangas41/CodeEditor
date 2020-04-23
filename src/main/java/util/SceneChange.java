package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneChange {

    public static void sceneChangeButton(String fxml, Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(SceneChange.class.getClassLoader().getResource(fxml)));

            Scene newScene = new Scene(root);
            Stage newStage = new Stage();

            newStage.setResizable(false);
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            newStage.getIcons().add(img);
            newStage.setTitle("Code Learner");

            newStage.setScene(newScene);
            newStage.show();
            newScene.getUserData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
