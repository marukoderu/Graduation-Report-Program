import students.Students;
import students.StudentsApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void displayMenu() {
        System.out.println("=============================");
        System.out.println("WELCOME TO GRADUATE REPORT");
        System.out.println("Here you can see the status \nof your graduation based on score");
        System.out.println("=============================");
        System.out.println("Select Menu :");

        System.out.println("1. View Students");
        System.out.println("2. Add Student");
        System.out.println("3. Edit Student");
        System.out.println("4. Delete Student");
        System.out.println("0, Exit");
    }

    public static void viewStudents(StudentsApp studentsApp) {
        ArrayList<Students> Students = new ArrayList<>();
        studentsApp.viewStudents(Students);
    }

    public static void addStudent(StudentsApp studentsApp) {
        Scanner input = new Scanner(System.in);

        System.out.println("Add New Student");
        System.out.println("Student ID:");
        String studentID = input.nextLine();

        System.out.println("Student Name:");
        String studentName = input.nextLine();

        System.out.println("Student Class:");
        String studentClass = input.nextLine();

        System.out.println("Student Department:");
        String studentDepartment = input.nextLine();

        ArrayList<Integer> scores = new ArrayList<>();
        System.out.println("Student Scores (input the number):");
        int score;
        int i = 1;
        while (true) {
            System.out.println("Score " + i + ":");
            score = input.nextInt();
            if (score == -1) {
                break;
            }
            i++;
            scores.add(score);
        }

        Students student = new Students(studentID, studentName, studentClass, studentDepartment);
        studentsApp.addStudents(student);

    }

    public static void editStudent(StudentsApp studentsApp) {
        Scanner input = new Scanner(System.in);
        int choice;

        ArrayList<Students> Students = new ArrayList<>();
        studentsApp.viewStudents(Students);

        System.out.println("Select Student ID you want to edit!");
        String taskID = input.nextLine();

        Students studentToEdit = studentsApp.findStudentByID(taskID);
        System.out.println(studentToEdit);

        if (studentToEdit != null) {
            System.out.println("1. Edit Name");
            System.out.println("Select what you want to edit:");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    input.nextLine();
                    System.out.println("Enter new name:");
                    String newName = input.nextLine();
                    studentToEdit.setStudentName(newName);
                    break;
                default:
                    System.out.println("Invalid");
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void deleteStudent(StudentsApp studentsApp) {
        Scanner input = new Scanner(System.in);
        int choice;

        ArrayList<Students> Students = new ArrayList<>();
        studentsApp.viewStudents(Students);

        System.out.println("Select Student ID you want to delete!");
        String taskID = input.nextLine();

        Students studentToDelete = studentsApp.findStudentByID(taskID);
        System.out.println(studentToDelete);

        if (studentToDelete != null) {
            studentsApp.deleteStudents(studentToDelete);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found!");
        }
    }
}
