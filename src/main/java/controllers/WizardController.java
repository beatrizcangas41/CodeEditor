package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Question;
import util.DialogCreator;

import java.util.ArrayList;

public class WizardController {

    @FXML public TextField answerTextField, progressValue;
    @FXML public TextArea questionDescription;
    @FXML public ProgressBar progressBar;
    @FXML private Button nextButton, backButton, finishButton;

    ObservableList<Question> questions = FXCollections.observableArrayList();
    WizardStartController wizardStartController;

    String moduleName, languageName, answerSubmitted;
    ArrayList<String> answers;
    double progressNumber, progressPercentage, arraySize, i = 1;
    int questNumber;

    @FXML public void init() {
        wizardStartController = new WizardStartController();
        System.out.println("language: " + languageName + "\n" + "module: " + moduleName);
//      questionDescription.setText(questions.get(0).getDescription());
    }

    public final void setQuestions(ObservableList<Question> questions) {
        this.questions = questions;
    }

    public ObservableList<Question> getQuestions() {
        return questions;
    }

    public ArrayList<String> getSubmittedAnswers() {
        return answers;
    }

    public void setSubmittedAnswers() {
        answers.add(answerSubmitted);
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

    public final void disableNextButton() {
        finishButton.setDisable(true);
        backButton.setDisable(true);
    }

    public double increasingQuestionArray() {
        return i++;
    }

    public double decreasingQuestionArray() { return i--; }

    @FXML public void nextButton(ActionEvent actionEvent) {

        if(answerTextField.getText().isEmpty())
            DialogCreator.displayErrorDialog("Answer missing", "No Answer has been Provided" , "Please try again");

        else {
            System.out.println("NEXT Button Pressed");

            arraySize = questions.size();
            System.out.println("array size: " + arraySize);

            System.out.println("old question: " + i);
            questNumber = (int) increasingQuestionArray();
            System.out.println("new question: " + i);

            backButton.setDisable(false);

            progressNumber = i / arraySize;
            progressPercentage = progressNumber * 100;

            String percentageResult = String.format("%.2f", progressPercentage);

            System.out.println("Progress Number: " + progressNumber);
            System.out.println("Progress %: " + progressPercentage);

            if (questNumber < questions.size() - 1) {
                questionDescription.setText(questions.get(questNumber).getDescription());
                progressBar.setProgress(progressNumber);
                progressValue.setText(percentageResult + '%');

                answerSubmitted = answerTextField.getText();
                answerTextField.clear();
            }

            else if (questNumber == questions.size() - 1) {
                questionDescription.setText(questions.get(questNumber).getDescription() +
                        '\n' + '\n' + "Press DONE when you are finished");
                progressBar.setProgress(progressNumber);
                progressValue.setText(percentageResult + '%');

                finishButton.setDisable(false);
                nextButton.setDisable(true);
            }
        }
    }

    @FXML public void backButton(ActionEvent actionEvent) {

    }

    @FXML public void finishButton(ActionEvent actionEvent) {

    }
}