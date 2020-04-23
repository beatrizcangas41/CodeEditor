package model;

import java.util.ArrayList;
import java.util.List;

public class Score extends Question {
    private double score;

    private int questionId, moduleId, programmingLanguageId,
            numberOfCorrectAnswers, numberOfIncorrectAnswers, totalNumberOfAnswers;
    private String submittedAnswer;
    private String programmingLanguage;
    private String moduleName;
    private String lastName;
    private String firstName;

    public Score(int score) {
        this.score = score;
    }

    public Score(int questionId, int moduleId, int programmingLanguageId, String submittedAnswer) {
        this.questionId = questionId;
        this.moduleId = moduleId;
        this.programmingLanguageId = programmingLanguageId;
        this.submittedAnswer = submittedAnswer;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Question> questions = new ArrayList<>();
//    score = getNumberOfCorrectAnswers() / getTotalNumberOfQuestionsAnswered() * 100

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getProgrammingLanguageId() {
        return programmingLanguageId;
    }

    public void setProgrammingLanguageId(int programmingLanguageId) {
        this.programmingLanguageId = programmingLanguageId;
    }

    public int getTotalNumberOfAnswers() {
        return totalNumberOfAnswers;
    }

    public void setTotalNumberOfAnswers(int totalNumberOfAnswers) {
        this.totalNumberOfAnswers = totalNumberOfAnswers;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    private int getTotalNumberOfQuestionsAnswered() {
        for (Question q : questions) if (isQuestionAnswered()) ++totalNumberOfAnswers;
        return totalNumberOfAnswers;
    }

    private void setTotalNumberOfAnswered(int totalNumberOfAnswers) {
        this.totalNumberOfAnswers = totalNumberOfAnswers;
    }

    private int getNumberOfCorrectAnswers() {
        for (Question q : questions) if (isQuestionCorrect()) ++numberOfCorrectAnswers;
        return numberOfCorrectAnswers;
    }

    public void setNumberOfCorrectAnswers(int incorrectAnswers) {
        this.numberOfIncorrectAnswers = incorrectAnswers;
    }

    public int getNumberOfIncorrectAnswers() {
        numberOfIncorrectAnswers = totalNumberOfAnswers - numberOfCorrectAnswers;
        return totalNumberOfAnswers;
    }

    public void setNumberOfIncorrectAnswers(int incorrectAnswers) {
        this.numberOfIncorrectAnswers = incorrectAnswers;
    }

    @Override
    public String toString() {
        return "Question #: " + questionId + "\n" +
                "Module #: " + this.moduleId + "\n" +
                "Programming Lang #: " + this.programmingLanguageId + "\n" +
                "Submitted Answer: " + this.submittedAnswer + "\n\n";

    }
}
