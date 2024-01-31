package students;

import java.util.ArrayList;

public class StudentsApp implements StudentsManagement {

    private ArrayList<Students> studentsList;

    public StudentsApp() {
        studentsList = new ArrayList<>();
    }

    @Override
    public void viewStudents(ArrayList<Students> students) {
        for (Students student : studentsList) { // Iterate over studentsList
            System.out.println(student);
        }
    }

    @Override
    public void addStudents(Students students) {
        studentsList.add(students);
    }

    @Override
    public void editStudents(Students students) {

    }

    @Override
    public void deleteStudents(Students students) {
        studentsList.remove(students);
    }

    public Students findStudentByID(String taskID) {
        for (Students student : studentsList) {
            if (student.getStudentID().equals(taskID)) {
                return student;
            }
        }
        return null;
    }
}
