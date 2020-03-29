package model;

import java.util.ArrayList;
import java.util.List;

public class Performance extends Score {

    private static double performance;
    private List <Score> scores = new ArrayList<>();
    private double score;

    public double getPerformance() {
        for (Score s : scores) score = s.getScore();
        double sumOfScores = ++score;
        return performance = sumOfScores / scores.size() * 100;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }

}
