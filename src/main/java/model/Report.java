package model;

public class Report {

    private double score;
    private int numberOfCorrectAnswers, numberOfIncorrectAnswers, totalNumberOfAnswers;
    private String programmingLanguage;
    private String moduleName;
    private String lastName;
    private String firstName;

    public Report(String moduleName, String programmingLanguage,
                  double score, int numberOfCorrectAnswers, int totalNumberOfAnswers) {
        this.moduleName = moduleName;
        this.programmingLanguage = programmingLanguage;
        this.score = score;
        this.totalNumberOfAnswers = totalNumberOfAnswers;
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
    }


    public Report(String firstName, String lastName, String moduleName, String programmingLanguage,
                  double score, int totalNumberOfAnswers, int numberOfCorrectAnswers, int numberOfIncorrectAnswers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.moduleName = moduleName;
        this.programmingLanguage = programmingLanguage;
        this.score = score;
        this.totalNumberOfAnswers = totalNumberOfAnswers;
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
        this.numberOfIncorrectAnswers = numberOfIncorrectAnswers;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
    }

    public int getNumberOfIncorrectAnswers() {
        return numberOfIncorrectAnswers;
    }

    public void setNumberOfIncorrectAnswers(int numberOfIncorrectAnswers) {
        this.numberOfIncorrectAnswers = numberOfIncorrectAnswers;
    }

    public int getTotalNumberOfAnswers() {
        return totalNumberOfAnswers;
    }

    public void setTotalNumberOfAnswers(int totalNumberOfAnswers) {
        this.totalNumberOfAnswers = totalNumberOfAnswers;
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

    @Override
    public String toString() {
        return "Module Name:\t\t\t\t" + this.moduleName + "\n" +
                "Programming Language:  \t" + this.programmingLanguage + "\n" +
                "Score:\t\t\t\t\t" + this.score + "\n" +
                "# of Questions:\t\t\t" + this.totalNumberOfAnswers + "\n" +
                "# of Correct Answers: \t\t" + this.numberOfCorrectAnswers + "\n\n\n";
    }
}
