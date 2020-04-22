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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static database.ModuleDBHandler.getModuleIDFromName;
import static database.ProgrammingLanguageDBHandler.getLanguageIDFromName;
import static database.ScoreAndPerfDBHandler.*;
import static database.UserDBHandler.getUserIDByUsername;

public class WizardController {

    @FXML public TextField answerTextField, progressValue;
    @FXML public TextArea questionDescription;
    @FXML public ProgressBar progressBar;
    @FXML public RadioButton radioButtonA, radioButtonB, radioButtonC, radioButtonD;
    @FXML private Button nextButton, backButton, finishButton;

    ToggleGroup group = new ToggleGroup();

    ObservableList<Question> questions0 = FXCollections.observableArrayList();
    List<Score> scores = new ArrayList<>();

    WizardStartController wizardStartController;
    WizardDoneController wizardDoneController;

    String username, moduleName, languageName, answerSubmitted, scorePercentage;
    ArrayList<String> answers;
    double progressNumber, progressPercentage, arraySize;
    double numberOfCorrectAnswers = 0, score, scorePercent;
    int questNumber, arrayNumber;
    String letterChoice = null, questionType;

    @FXML public void initialize() {
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
        System.out.println("(set) assign Language Name to string variable: " + languageName);
    }

    public final String getLanguageName() {
        System.out.println("LPC - (get) Language Name: " + languageName);
        return languageName;
    }

    public final void setQuestNumber(int questNumber) {

        this.questNumber = questNumber;
        // moduleName = Module1Button.getText();
        System.out.println("(set) assign Quest #: " + questNumber);
    }

    public final int getQuestNumber() {
        System.out.println("(get) Quest #: " + questNumber);
        return questNumber;
    }

    public final void setModuleName(String name) {
        this.moduleName = name;
        System.out.println("(set) assign Module Name to string variable: " + moduleName);
    }

    public final String getModuleName() {
        System.out.println("(get) Module Name: " + moduleName);
        return moduleName;
    }

    public final void setUsername(String name) {
        this.username = name;
        System.out.println("(set) assign Username to string variable: " + username);
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

    public void deselectAllToggleGroup() {
        radioButtonA.setSelected(false);
        radioButtonB.setSelected(false);
        radioButtonC.setSelected(false);
        radioButtonD.setSelected(false);
//      Toggle toggle = group.getSelectedToggle();
//      group.getToggles().remove(toggle);
    }

    @FXML public void nextButton(ActionEvent actionEvent) throws SQLException {

        if (group.getSelectedToggle() == null)
            DialogCreator.displayErrorDialog("Answer missing", "No Answer has been Provided", "Please try again");

        else {
            System.out.println("NEXT Button Pressed");

            arraySize = questions0.size();
            System.out.println("array size: " + arraySize);
            System.out.println("old question: " + questNumber);
            questNumber++;
            System.out.println("new question: " + questNumber);
            arrayNumber = questNumber - 1;

            if (questNumber > 1 && questNumber < arraySize) {
                nextButton.setDisable(false);
                backButton.setDisable(false);
            }
            else if (questNumber == 1) backButton.setDisable(true);
            else if (questNumber == arraySize) nextButton.setDisable(true);

            questionType = questions0.get(arrayNumber).getQuestion_type();
            System.out.println("question type: " + questionType);

            progressNumber = questNumber / arraySize;
            progressPercentage = progressNumber * 100;

            String percentageResult = String.format("%.2f", progressPercentage);
            System.out.println("Progress %: " + progressPercentage);

            if (questNumber < questions0.size()) questionDescription.setText(questions0.get(arrayNumber).getDescription());
            else if (questNumber == questions0.size()) {
                questionDescription.setText(questions0.get(arrayNumber).getDescription() +
                        '\n' + '\n' + "Press DONE when you are finished");

                finishButton.setDisable(false);
                nextButton.setDisable(true);
            }

            questionDescription.setWrapText(true);
            progressBar.setProgress(progressNumber);
            progressValue.setText(percentageResult + '%');

            setToggleGroup();
            String optionA = questions0.get(arrayNumber).getOptionA(),
                    optionB = questions0.get(arrayNumber).getOptionB(),
                    optionC = questions0.get(arrayNumber).getOptionC(),
                    optionD = questions0.get(arrayNumber).getOptionD();

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

            System.out.println("answer submitted: " + answerSubmitted);
            if (answerSubmitted.equals(radioButtonA.getText())) letterChoice = "A";
            else if (answerSubmitted.equals(radioButtonB.getText())) letterChoice = "B";
            else if (answerSubmitted.equals(radioButtonC.getText())) letterChoice = "C";
            else if (answerSubmitted.equals(radioButtonD.getText())) letterChoice = "D";

            int moduleID = getModuleIDFromName(getModuleName());
            int languageID = getLanguageIDFromName(getLanguageName());

            scores.add(new Score(questNumber, moduleID, languageID, letterChoice));
            deselectAllToggleGroup();
        }
    }

    @FXML public void backButton(ActionEvent actionEvent) throws SQLException {
        System.out.println("BACK Button Pressed");

        System.out.println("old question: " + questNumber);
        questNumber--;
        System.out.println("new question: " + questNumber);
        arrayNumber = questNumber - 1;

        arraySize = questions0.size();
        System.out.println("array size: " + arraySize);

        if (questNumber == 1) backButton.setDisable(true);
        if (questNumber == questions0.size()) nextButton.setDisable(false);

        questionType = questions0.get(arrayNumber).getQuestion_type();
        System.out.println("question type: " + questionType);

        progressNumber = questNumber / arraySize;
        progressPercentage = progressNumber * 100;

        String percentageResult = String.format("%.2f", progressPercentage);
        System.out.println("Progress %: " + progressPercentage);

        questionDescription.setText(questions0.get(arrayNumber).getDescription());
        questionDescription.setWrapText(true);
        progressBar.setProgress(progressNumber);
        progressValue.setText(percentageResult + '%');

        String optionA = questions0.get(arrayNumber).getOptionA();
        String optionB = questions0.get(arrayNumber).getOptionB();
        String optionC = questions0.get(arrayNumber).getOptionC();
        String optionD = questions0.get(arrayNumber).getOptionD();

        setToggleGroup();

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

        if (!selectedRadioButton.getText().isEmpty()) {
            answerSubmitted = selectedRadioButton.getText();
            System.out.println("answer submitted: " + answerSubmitted);

            if (answerSubmitted.equals(radioButtonA.getText())) letterChoice = "A";
            else if (answerSubmitted.equals(radioButtonB.getText())) letterChoice = "B";
            else if (answerSubmitted.equals(radioButtonC.getText())) letterChoice = "C";
            else if (answerSubmitted.equals(radioButtonD.getText())) letterChoice = "D";

            int moduleID = getModuleIDFromName(getModuleName());
            int languageID = getLanguageIDFromName(getLanguageName());

            if (scores.get(arrayNumber).getSubmittedAnswer() != null && !answerSubmitted.isEmpty()) {
                scores.remove(arrayNumber);
            }
            scores.add(new Score(questNumber, moduleID, languageID, letterChoice));

            deselectAllToggleGroup();
        }
    }

    @FXML public void finishButton(ActionEvent actionEvent) throws SQLException {

        if (group.getSelectedToggle() == null)
            DialogCreator.displayErrorDialog("Answer missing", "No Answer has been Provided", "Please try again");

        else {
            System.out.println("questions array: " + questions0);
            System.out.println("submitted questions: " + scores);

            for (int j = 0; j < arraySize - 1; j++)
                if (questions0.get(j).getSolution().equals(scores.get(j).getSubmittedAnswer()))
                    numberOfCorrectAnswers++;

            score = numberOfCorrectAnswers / arraySize;
            scorePercent = score * 100;
            scorePercentage = String.format("%.2f", scorePercent);

            int numberOfIncorrectAnswers = (int) (arraySize - numberOfCorrectAnswers);

            System.out.println("number of correct questions: " + (int) numberOfCorrectAnswers);
            System.out.println("number of incorrect questions: " + numberOfIncorrectAnswers);
            System.out.println("total number of questions: " + (int) arraySize + "\n");
            System.out.println("score: " + score);
            System.out.println("score %: " + scorePercent + "\n");
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

            System.out.println("userID: " + userID);

            ResultSet resultSet = getScoresOfUser(userID);
            boolean userExists = checkIfUserExistsInPerformance(userID);
            ArrayList<Double> scores1 = new ArrayList<>();
            double performance = 0;

            while (resultSet.next()) scores1.add(resultSet.getDouble("score"));
            System.out.println("scores: " + scores1);

            for (int a = 0; a < scores1.size(); a++) {
                System.out.println("a: " + a);
                System.out.println("scores1.get(a): " + scores1.get(a));
                performance = performance + scores1.get(a);
                System.out.println("perf sum: " + performance);
            }

            performance = (performance / scores1.size());
            System.out.println("perf avg: " + performance);
            String perfResult = String.format("%.2f", performance);

            if (userExists) {
                System.out.println("user exists - UPDATE");
                updatePerformance(performance, userID);
            }

            else {
                System.out.println("user does NOT exist - CREATE");
                addPerformance(performance, userID);
            }

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
                        "PERFORMANCE: " + perfResult + " %");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}