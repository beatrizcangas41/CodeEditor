package model;

public class Question {
    private static boolean questionAnswered, questionCorrect;
    private int questionId;
    private static int totalNumberOfQuestions = 0;
    private String answer, description, solution, choice_solution, question_type;

    public Question() {
        this.answer = null;
        this.description = null;
        this.solution = null;
    }

    public Question(int questionID, String description, String questionType, String choice_solution, int moduleID, int languageID) {
        this.questionId = questionID;
        this.description = description;
        this.question_type = questionType;
        this.choice_solution = choice_solution;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getChoice_solution() {
        return choice_solution;
    }

    public void setChoice_solution(String choice_solution) {
        this.choice_solution = choice_solution;
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

    public int questionIdProperty() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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
