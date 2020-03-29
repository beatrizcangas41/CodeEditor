package model;

import java.util.ArrayList;
import java.util.List;

public class Score extends Question {
    private double score;
    private int NumberOfCorrectAnswers, NumberOfIncorrectAnswers, totalNumberOfAnswers;
    public List<Question> questions = new ArrayList<>();

    public Score() {
        this.score = 0;
        this.NumberOfCorrectAnswers = 0;
        this.NumberOfIncorrectAnswers = 0;
        this.totalNumberOfAnswers = 0;
    }

    public double getScore() {
        return score = getNumberOfCorrectAnswers() / getTotalNumberOfQuestionsAnswered() * 100;
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
}
