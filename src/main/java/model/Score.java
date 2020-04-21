package model;

import java.util.ArrayList;
import java.util.List;

public class Score extends Question {
    private double score;

    private int questionId, moduleId, programmingLanguageId,
            NumberOfCorrectAnswers, NumberOfIncorrectAnswers, totalNumberOfAnswers;
    private String submittedAnswer;
    public List<Question> questions = new ArrayList<>();
//    score = getNumberOfCorrectAnswers() / getTotalNumberOfQuestionsAnswered() * 100

    public Score(int score) {
        this.score = score;
    }

    public Score(int questionId, int moduleId, int programmingLanguageId, String submittedAnswer) {
        this.questionId = questionId;
        this.moduleId = moduleId;
        this.programmingLanguageId = programmingLanguageId;
        this.submittedAnswer = submittedAnswer;
    }

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
        for (Question q : questions) if (isQuestionCorrect()) ++NumberOfCorrectAnswers;
        return NumberOfCorrectAnswers;
    }

    public void setNumberOfCorrectAnswers(int incorrectAnswers) {
        this.NumberOfIncorrectAnswers = incorrectAnswers;
    }

    public int getNumberOfIncorrectAnswers() {
        NumberOfIncorrectAnswers = totalNumberOfAnswers - NumberOfCorrectAnswers;
        return totalNumberOfAnswers;
    }

    public void setNumberOfIncorrectAnswers(int incorrectAnswers) {
        this.NumberOfIncorrectAnswers = incorrectAnswers;
    }

    @Override
    public String toString() {
        return "Question #: " + questionId + "\n" +
                "Module #: " + this.moduleId + "\n" +
                "Programming Lang #: " + this.programmingLanguageId + "\n" +
                "Submitted Answer: " + this.submittedAnswer + "\n\n";
    }
}
