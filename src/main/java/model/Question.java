package model;

public class Question {
    private static boolean questionAnswered, questionCorrect;
    private int questionId;
    private int moduleId;
    private int programmingLanguageId;
    private static int totalNumberOfQuestions = 0;
    private String answer, submittedAnswer;
    private String description;
    private String solution;
    private String choice_solution;
    private String question_type;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    public Question() {
        this.answer = null;
        this.description = null;
        this.solution = null;
    }

    public Question(int questionId, int moduleId, int programmingLanguageId, String submittedAnswer) {
        this.questionId = questionId;
        this.moduleId = moduleId;
        this.programmingLanguageId = programmingLanguageId;
        this.submittedAnswer = submittedAnswer;
    }

    public Question(int questionID, String description, String questionType, String choice_solution, int moduleID, int languageID) {
        this.questionId = questionID;
        this.description = description;
        this.question_type = questionType;
        this.choice_solution = choice_solution;
    }

    public Question(int questionID, String description, String questionType, String solution,
                    int moduleID, int languageID, String optionA, String optionB, String optionC, String optionD) {
        this.questionId = questionID;
        this.description = description;
        this.question_type = questionType;
        this.solution = solution;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
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

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
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
        return "Question #: " + questionId + "\n" +
                "Question Description: " + this.description + "\n" +
                "Question Type: " + this.question_type + "\n" +
                "Correct Answer: " + this.solution + "\n\n";
    }
}
