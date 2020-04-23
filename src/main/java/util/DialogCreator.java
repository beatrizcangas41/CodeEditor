package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class DialogCreator {

    public static void displayErrorDialog(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void displayInformationDialog(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void displayConfirmationDialog(String title, String header, String message, String fxml) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.CANCEL) {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxml));
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            Parent parent = loader.load();

            Scene newScene = new Scene(parent);
            Stage newStage = new Stage();
            newStage.setResizable(false);
            newStage.getIcons().add(img);
            newStage.setTitle("Code Learner");
            newStage.setOnCloseRequest(event -> System.exit(0));

            newStage.setScene(newScene);
            newStage.show();
        }
    }
}
