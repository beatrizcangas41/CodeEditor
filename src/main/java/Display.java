import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Question;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Display extends Application {

    private ArrayList<Question> question = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent page = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/loginScreenUI.fxml")));
        Scene scene = new Scene(page, 800, 500);
        Stage stage = new Stage();
        stage.setTitle("Code Learner");

        stage.setScene(scene);
        stage.show();
    }

    public void addQuestionList(Question book) {
        // Question.add(question);
    }

    public static void main(String[] args) {
        launch(args);
    }
}