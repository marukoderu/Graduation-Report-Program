package students;

import java.util.ArrayList;

public interface StudentsManagement {
    void viewStudents(ArrayList<Students> students);
    void addStudents(Students students);
    void editStudents(Students students);
    void deleteStudents(Students students);
}
