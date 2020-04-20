package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Question;
import model.Score;
import util.DialogCreator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static database.ModuleDBHandler.getModuleIDFromName;
import static database.ProgrammingLanguageDBHandler.getLanguageIDFromName;
import static database.ScoreDBHandler.addScore;
import static database.UserDBHandler.getUserIDByUsername;

public class WizardController {

    @FXML public TextField answerTextField, progressValue;
    @FXML public TextArea questionDescription;
    @FXML public ProgressBar progressBar;
    @FXML public RadioButton radioButtonA, radioButtonB, radioButtonC, radioButtonD;
    @FXML private Button nextButton, backButton, finishButton;

    ToggleGroup group = new ToggleGroup();

    ObservableList<Question> questions0 = FXCollections.observableArrayList();
    ObservableList<Score> scores = FXCollections.observableArrayList();

    WizardStartController wizardStartController;
    WizardDoneController wizardDoneController;

    String username, moduleName, languageName, answerSubmitted, scorePercentage;
    ArrayList<String> answers;
    double progressNumber, progressPercentage, arraySize, i = 1;
    double numberOfCorrectAnswers = 0, score, scorePercent;
    int questNumber;
    String letterChoice = null;

    @FXML public void initialize()  {
        wizardStartController = new WizardStartController();
        System.out.println("language: " + languageName + "\n" + "module: " + moduleName);
    }

    public final void setQuestions0(ObservableList<Question> questions0) {
        this.questions0 = questions0;
    }

    public ObservableList<Question> getQuestions0() {
        return questions0;
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

    public final void setUsername(String name) {
        this.username = name;
        System.out.println(" (set) assign Username to string variable: " + username);
    }

    public final String getUsername() {
        System.out.println("(get) username: " + username);
        return username;
    }

    public final void disableNextButton() {
        finishButton.setDisable(true);
        backButton.setDisable(true);
    }

    public final void setToggleGroup() {
        radioButtonA.setToggleGroup(group);
        radioButtonB.setToggleGroup(group);
        radioButtonC.setToggleGroup(group);
        radioButtonD.setToggleGroup(group);
    }

    public double increasingQuestionArray() {
        return i++;
    }

    public double decreasingQuestionArray() { return i--; }

    @FXML public void nextButton(ActionEvent actionEvent) throws SQLException {

        if(group.getSelectedToggle() == null)
            DialogCreator.displayErrorDialog("Answer missing", "No Answer has been Provided" , "Please try again");

        else {
            System.out.println("NEXT Button Pressed");

            arraySize = questions0.size();
            System.out.println("array size: " + arraySize);

            System.out.println("old question: " + i);
            questNumber = (int) increasingQuestionArray();
            System.out.println("new question: " + i);
            int j = (int) i;

            String questionType = questions0.get(questNumber).getQuestion_type();
            System.out.println("question type: " + questionType);

            backButton.setDisable(false);

            progressNumber = i / arraySize;
            progressPercentage = progressNumber * 100;

            String percentageResult = String.format("%.2f", progressPercentage);

            System.out.println("Progress Number: " + progressNumber);
            System.out.println("Progress %: " + progressPercentage);

            String optionA = questions0.get(questNumber).getOptionA();
            String optionB = questions0.get(questNumber).getOptionB();
            String optionC = questions0.get(questNumber).getOptionC();
            String optionD = questions0.get(questNumber).getOptionD();

            int moduleID = getModuleIDFromName(getModuleName());
            int languageID = getLanguageIDFromName(getLanguageName());

            if (questNumber < questions0.size() - 1) {
                questionDescription.setText(questions0.get(questNumber).getDescription());
                progressBar.setProgress(progressNumber);
                progressValue.setText(percentageResult + '%');

                if (questionType.equals("True / False")) {
                    radioButtonC.setDisable(true);
                    radioButtonD.setDisable(true);

                    radioButtonC.setVisible(false);
                    radioButtonD.setVisible(false);

                    radioButtonA.setText(optionA);
                    radioButtonB.setText(optionB);
                }
                else if (questionType.equals("Multiple Choice")) {
                    radioButtonC.setDisable(false);
                    radioButtonD.setDisable(false);

                    radioButtonC.setVisible(true);
                    radioButtonD.setVisible(true);

                    radioButtonA.setText(optionA);
                    radioButtonB.setText(optionB);
                    radioButtonC.setText(optionC);
                    radioButtonD.setText(optionD);
                }

                RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
                answerSubmitted = selectedRadioButton.getText();

            }

            else {
                questionDescription.setText(questions0.get(questNumber).getDescription() +
                        '\n' + '\n' + "Press DONE when you are finished");
                progressBar.setProgress(progressNumber);
                progressValue.setText(percentageResult + '%');

                finishButton.setDisable(false);
                nextButton.setDisable(true);

                if (questionType.equals("True / False")) {
                    radioButtonC.setDisable(true);
                    radioButtonD.setDisable(true);

                    radioButtonC.setVisible(false);
                    radioButtonD.setVisible(false);

                    radioButtonA.setText(optionA);
                    radioButtonB.setText(optionB);
                }
                else if (questionType.equals("Multiple Choice")) {
                    radioButtonC.setDisable(false);
                    radioButtonD.setDisable(false);

                    radioButtonC.setVisible(true);
                    radioButtonD.setVisible(true);

                    radioButtonA.setText(optionA);
                    radioButtonB.setText(optionB);
                    radioButtonC.setText(optionC);
                    radioButtonD.setText(optionD);
                }

                RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
                answerSubmitted = selectedRadioButton.getText();

            }
            System.out.println("answer submitted: " + answerSubmitted);
            if (answerSubmitted.equals(radioButtonA.getText())) letterChoice = "A";
            else if (answerSubmitted.equals(radioButtonB.getText())) letterChoice = "B";
            else if (answerSubmitted.equals(radioButtonC.getText())) letterChoice = "C";
            else if (answerSubmitted.equals(radioButtonD.getText())) letterChoice = "D";

            scores.add(new Score(j, moduleID, languageID, letterChoice));

            Toggle toggle = group.getSelectedToggle();
            group.getToggles().remove(toggle);

            setToggleGroup();
        }
    }

    @FXML public void backButton(ActionEvent actionEvent) {
        if(i == 1) backButton.setDisable(true);

        else {
            System.out.println("BACK Button Pressed");

            arraySize = questions0.size();
            System.out.println("array size: " + arraySize);

            System.out.println("old question: " + i);
            questNumber = (int) decreasingQuestionArray();
            System.out.println("new question: " + i);

            progressNumber = i / arraySize;
            progressPercentage = progressNumber * 100;

            String percentageResult = String.format("%.2f", progressPercentage);

            System.out.println("Progress Number: " + progressNumber);
            System.out.println("Progress %: " + progressPercentage);

            questionDescription.setText(questions0.get(questNumber).getDescription());
            progressBar.setProgress(progressNumber);
            progressValue.setText(percentageResult + '%');

            if (i == 1) backButton.setDisable(true);

            answerSubmitted = answerTextField.getText();
            answerTextField.clear();
        }

    }

    @FXML public void finishButton(ActionEvent actionEvent) throws SQLException {

        System.out.println("questions array: " + questions0);
        System.out.println("submitted questions: " + scores);

        for (int j = 0; j < arraySize - 1; j++)
            if (questions0.get(j).getSolution().equals(scores.get(j).getSubmittedAnswer())) numberOfCorrectAnswers++;

        score = numberOfCorrectAnswers / arraySize;
        scorePercent = score * 100;
        scorePercentage = String.format("%.2f", scorePercent);

        int numberOfIncorrectAnswers = (int) (arraySize - numberOfCorrectAnswers);

        System.out.println("number of correct questions: " + (int) numberOfCorrectAnswers);
        System.out.println("number of incorrect questions: " + numberOfIncorrectAnswers);
        System.out.println("total number of questions: " + (int) arraySize + "\n");

        System.out.println("score: " + score);
        System.out.println("score %: " + "%.2f" + scorePercent + "\n");

        System.out.println("userName: " + getUsername());
        System.out.println("moduleName: " + getModuleName());
        System.out.println("languageName: " + getLanguageName() + "\n");

        int userID = getUserIDByUsername(getUsername());
        int moduleID = getModuleIDFromName(getModuleName());
        int languageID = getLanguageIDFromName(getLanguageName());
        int correctAnswers = (int) numberOfCorrectAnswers;
        int totalNumberOfQuest = (int) arraySize;

        System.out.println("Entered score : " + scorePercent + " " + userID + " " + moduleID +
                " " + languageID + " " + correctAnswers + " " + numberOfIncorrectAnswers + " " + totalNumberOfQuest);

        addScore(scorePercent, userID, moduleID, languageID, correctAnswers, numberOfIncorrectAnswers, totalNumberOfQuest);

        Stage stage = (Stage) finishButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/WizardDoneUI.fxml"));
            Parent parent = loader.load();

            wizardDoneController = loader.getController();

            Scene newScene = new Scene(parent);
            stage.setTitle("Code Learner");
            stage.setScene(newScene);
            stage.show();

            System.out.println("score: " + scorePercentage);
            wizardDoneController.setText("SCORE: " + scorePercentage + " %\n\n" +
                                         "PERFORMANCE: " + scorePercentage + " %");

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}