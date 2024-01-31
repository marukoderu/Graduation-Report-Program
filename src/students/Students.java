package students;

import java.util.ArrayList;

public class Students {

    // ATTRIBUTES
    private String studentID;
    private String studentName;
    private String studentClass;
    private String studentDepartment;
    private ArrayList<Integer> scores;

    // CONSTRUCTOR
    public Students(String id, String name, String classname, String department) {
        this.studentID = id;
        this.studentName = name;
        this.studentClass = classname;
        this.studentDepartment = department;
        this.scores = new ArrayList<>();
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

    public String toString() {
        return "ID: " + studentID + " | Name:" + studentName ;
    }
}
