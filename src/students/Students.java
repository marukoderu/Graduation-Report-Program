package students;

import java.util.ArrayList;

public class Students {

    // ATTRIBUTES
    private String studentID;
    private String studentName;
    private String studentClass;
    private String studentDepartment;
    private ArrayList<Integer> scores;
    private String scoreAverage;
    private String isGraduate;

    // CONSTRUCTOR
    public Students(String id, String name, String classname, String department, String scoreAverage, String isGraduate) {
        this.studentID = id;
        this.studentName = name;
        this.studentClass = classname;
        this.studentDepartment = department;
        this.scores = new ArrayList<>();
        this.scoreAverage = scoreAverage;
        this.isGraduate = isGraduate;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public String getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(String scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    public String getIsGraduate() {
        return isGraduate;
    }

    public void setIsGraduate(String isGraduate) {
        this.isGraduate = isGraduate;
    }

    public String toString() {
        StringBuilder scoresString = new StringBuilder();
        for (int i = 0; i < scores.size(); i++) {
            if (i > 0) {
                scoresString.append(", "); // Add comma and space before each score (except the first one)
            }
            scoresString.append(scores.get(i)); // Append the score
        }
        return "ID: " + studentID + " | Name: " + studentName + " | Class: " + studentClass + " | Scores" + scores.toString() + " | Score Average: " + scoreAverage + " | Status: " + isGraduate;
    }
}
