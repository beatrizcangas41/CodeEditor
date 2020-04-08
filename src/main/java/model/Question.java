package model;

import javafx.beans.property.SimpleIntegerProperty;

public class Question {
    private SimpleIntegerProperty questionId = new SimpleIntegerProperty();
    private String answer;
    private String description;
    private String solution;

    private String question_type;
    private static boolean questionAnswered, questionCorrect;
    public static int totalNumberOfQuestions = 0;

    public Question() {
        this.answer = null;
        this.description = null;
        this.solution = null;
    }

    public Question(String answer, String description, String solution) {
        this.answer = answer;
        this.description = description;
        this.solution = solution;
    }

    public Question(String description, String solution) {
        this.description = description;
        this.solution = solution;
    }
    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public static int getTotalNumberOfQuestions() {
        return totalNumberOfQuestions;
    }

    public static void setTotalNumberOfQuestions(int totalNumberOfQuestions) {
        Question.totalNumberOfQuestions = totalNumberOfQuestions;
    }

    public static boolean isQuestionCorrect() {
        return questionCorrect;
    }

    public static void setQuestionCorrect(boolean questionCorrect) {
        Question.questionCorrect = questionCorrect;
    }

    public static boolean isQuestionAnswered() {
        return questionAnswered;
    }

    public static void setQuestionAnswered(boolean questionAnswered) {
        Question.questionAnswered = questionAnswered;
    }

    public int getQuestionId() {
        return questionId.get();
    }

    public SimpleIntegerProperty questionIdProperty() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId.set(questionId);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "Total Number of Questions Attempted: \t" + totalNumberOfQuestions + "\n" +
                "Question #: \t" + this.description + "\n" +
                "Correct Answer: " + this.solution + "\n\n";
    }
}
