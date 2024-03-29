package controllers;

import database.QuestionDBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Question;
import util.SceneChange;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class WizardStartController {

    @FXML private Button goBackButton, startButton;
    @FXML private TextField moduleName;

    ModulePickerController modulePickerController;
    WizardController wizardController;

    String username, setModuleName, languageName;

    @FXML
    public void initialize() {
        System.out.println("initializing");
        modulePickerController = new ModulePickerController();
    }

    public String getModuleName() {
        return moduleName.getText();
    }

    public void setModuleName(String name) {
        System.out.println("string passed: " + name);
        moduleName.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-text-inner-color:  #80807E");
        moduleName.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        if (name.equals("Hello World!, Line & Block Comments")) moduleName.setAlignment(Pos.CENTER_LEFT);
        else moduleName.setAlignment(Pos.CENTER);

        moduleName.setText(name);
        System.out.println("text field: " + getModuleName());
    }

    public final void setLanguageName(String languageName) {

        this.languageName = languageName;
        // moduleName = Module1Button.getText();
        System.out.println("(set) assign Language Name to string variable: " + languageName);
    }

    public final String getLanguageName() {
        System.out.println("LPC - (get) Language Name: " + languageName);
        return languageName;
    }

    public final String getUsername() {
        System.out.println("(get) username: " + username);
        return username;
    }

    public final void setUsername(String name) {
        this.username = name;
        System.out.println("(set) assign Username to string variable: " + username);
    }

    public void goBackButton(ActionEvent actionEvent) throws SQLException {

        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ModulePickerUI.fxml"));
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            Parent parent = loader.load();

            stage = new Stage();
            stage.setResizable(false);

            stage.getIcons().add(img);

            stage.setTitle("Code Learner");
            stage.setScene(new Scene(parent));
            stage.show();
            stage.setOnCloseRequest(event -> System.exit(0));

            modulePickerController = loader.getController();
            System.out.println("Setting Language Name in Module Picker: " + languageName);
            modulePickerController.setLanguageName(getLanguageName());
            modulePickerController.setButtonText(getLanguageName());
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToQuestions(ActionEvent actionEvent) throws SQLException {

        String description, questionType, choice_solution;
        int moduleID, languageID, questionNumber;

        ResultSet resultSet = QuestionDBHandler.getQuestionFromModuleAndLanguage(getModuleName(), getLanguageName());
        ObservableList<Question> question = FXCollections.observableArrayList();

        while (resultSet.next()) {

            System.out.println("questionNumber: " + Integer.parseInt(resultSet.getString("questionID")) + "\n" +
                    "description: " + resultSet.getString("description") + "\n" +
                    "questionType: " + resultSet.getString("question_Type") + "\n" +
                    "solution: " + resultSet.getString("solution") + "\n" +
                    "moduleID: " + resultSet.getString("moduleID") + "\n" +
                    "languageID: " + resultSet.getString("programming_language_ID") + "\n");

            question.add(new Question(
                    Integer.parseInt(resultSet.getString("questionID")),
                    resultSet.getString("description"),
                    resultSet.getString("question_type"),
                    resultSet.getString("choice_solution"),
                    Integer.parseInt(resultSet.getString("moduleID")),
                    Integer.parseInt(resultSet.getString("programming_language_ID")),
                    resultSet.getString("option_A"),
                    resultSet.getString("option_B"),
                    resultSet.getString("option_C"),
                    resultSet.getString("option_D")));
        }

        String initialDescription = question.get(0).getDescription();
        String initialQuestionType = question.get(0).getQuestion_type();
        String optionA = question.get(0).getOptionA();
        String optionB = question.get(0).getOptionB();
        String optionC = question.get(0).getOptionC();
        String optionD = question.get(0).getOptionD();

        System.out.println("1st question - description: " + initialDescription);
        System.out.println("1st question - question type: " + initialQuestionType);

        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardUI.fxml"));
            Image img = new Image(Objects.requireNonNull(SceneChange.class.getClassLoader().getResourceAsStream("images/FullColor_IconOnly_1280x1024_72dpi.jpg")));
            Parent parent = loader.load();

            wizardController = loader.getController();

            stage = new Stage();
            stage.setResizable(false);

            stage.getIcons().add(img);

            stage.setTitle("Code Learner");
            stage.setScene(new Scene(parent));
            stage.show();
            stage.setOnCloseRequest(event -> System.exit(0));

            wizardController.setModuleName(getModuleName());
            wizardController.setLanguageName(getLanguageName());
            wizardController.setQuestions0(question);
            wizardController.questionDescription.setText(initialDescription);
            wizardController.setUsername(getUsername());
            wizardController.finishButton.setDisable(true);
            wizardController.backButton.setDisable(true);
            wizardController.backButton.setVisible(false);
            wizardController.setToggleGroup();
            wizardController.setQuestNumber(1);


            if (initialQuestionType.equals("True / False")) {

                wizardController.radioButtonA.setText(optionA);
                wizardController.radioButtonB.setText(optionB);

                wizardController.radioButtonC.setDisable(true);
                wizardController.radioButtonC.setVisible(false);

                wizardController.radioButtonD.setDisable(true);
                wizardController.radioButtonD.setVisible(false);
            }
            else if (initialQuestionType.equals("Multiple Choice")) {
                wizardController.radioButtonA.setText(optionA);
                wizardController.radioButtonB.setText(optionB);
                wizardController.radioButtonC.setText(optionC);
                wizardController.radioButtonD.setText(optionD);
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
