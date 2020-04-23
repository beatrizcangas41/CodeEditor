import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Question;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Display extends Application {

    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent page = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/loginScreenUI.fxml")));
        primaryStage.setResizable(false);
        Image img = new Image(getClass().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg"));
        primaryStage.getIcons().add(img);
        primaryStage.setTitle("Code Learner");
        primaryStage.setScene(new Scene(page));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> System.exit(0));

    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public static void main(String[] args) {
        launch(args);
    }
}