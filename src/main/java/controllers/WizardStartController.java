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
import javafx.stage.Stage;
import model.Question;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WizardStartController {

    @FXML private Button goBackButton, startButton;
    @FXML private TextField moduleName;

    ModulePickerController modulePickerController;
    WizardController wizardController;

    String setModuleName, languageName;

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

    public final void setLanguageName(String name) {

        this.languageName = name;
        // moduleName = Module1Button.getText();
        System.out.println(" (set) assign Language Name to string variable: " + languageName);
    }

    public final String getLanguageName() {
        System.out.println("LPC - (get) Language Name: " + languageName);
        return languageName;
    }

    public void goBackButton(ActionEvent actionEvent) throws SQLException {

        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ModulePickerUI.fxml"));
            Parent parent = loader.load();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

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
                    "choice_solution: " + resultSet.getString("choice_solution") + "\n" +
                    "moduleID: " + resultSet.getString("moduleID") + "\n" +
                    "languageID: " + resultSet.getString("programming_language_ID") + "\n");

            question.add(new Question(
                    Integer.parseInt(resultSet.getString("questionID")),
                    resultSet.getString("description"),
                    resultSet.getString("question_type"),
                    resultSet.getString("choice_solution"),
                    Integer.parseInt(resultSet.getString("moduleID")),
                    Integer.parseInt(resultSet.getString("programming_language_ID"))));
        }

        String initialDescription = question.get(0).getDescription();
        String initialQuestionType = question.get(0).getQuestion_type();

        System.out.println("1st question - description: " + initialDescription);
        System.out.println("1st question - question type: " + initialQuestionType);

        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardUI.fxml"));
            Parent parent = loader.load();

            wizardController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            wizardController.setModuleName(getModuleName());
            wizardController.setLanguageName(getLanguageName());
            wizardController.setQuestions(question);
            wizardController.questionDescription.setText(initialDescription);
            wizardController.disableNextButton();
            wizardController.setToggleGroup();
            if (initialQuestionType.equals("True / False")) {
                wizardController.radioButtonC.setDisable(true);
                wizardController.radioButtonD.setDisable(true);

                wizardController.radioButtonC.setVisible(false);
                wizardController.radioButtonD.setVisible(false);
            }
            else if (initialQuestionType.equals("Multiple Choice")) {
                wizardController.radioButtonC.setDisable(false);
                wizardController.radioButtonD.setDisable(false);

                wizardController.radioButtonC.setVisible(true);
                wizardController.radioButtonD.setVisible(true);
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
