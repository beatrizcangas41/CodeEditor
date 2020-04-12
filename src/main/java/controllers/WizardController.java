package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Question;

public class WizardController {

    @FXML
    public TextField answerTextField;
    @FXML
    public TextArea questionDescription;
    @FXML
    private Button nextButton, backButton, finishButton;

    ObservableList<Question> questions = FXCollections.observableArrayList();

    WizardStartController wizardStartController;

    String moduleName, languageName;

    @FXML
    public void init() {
        finishButton.setDisable(true);
        wizardStartController = new WizardStartController();
        System.out.println("language: " + languageName + "\n" + "module: " + moduleName);
//        questionDescription.setText(questions.get(0).getDescription());
    }

    public final void setQuestions(ObservableList<Question> questions) {
        this.questions = questions;
    }

    public ObservableList<Question> getQuestions() {
        return questions;
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

    public final void setModuleName(String name) {
        this.moduleName = name;
        System.out.println(" (set) assign Module Name to string variable: " + moduleName);
    }

    public final String getModuleName() {
        System.out.println("(get) Module Name: " + moduleName);
        return moduleName;
    }

    // TODO - finish implementation

    @FXML
    public void nextButton(ActionEvent actionEvent) {

        String descriptionText = ((Button) actionEvent.getSource()).getText();
        System.out.println("Button text : " + descriptionText);

        System.out.println("Current question : " + descriptionText);
        questions.remove(0);
//        questionDescription.setText(questions.get(0).getDescription());

        for (Question q : questions) questionDescription.setText(questions.get(0).getDescription());

    }

}