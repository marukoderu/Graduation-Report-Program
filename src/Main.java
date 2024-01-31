import students.Students;
import students.StudentsApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner for input2
        StudentsApp studentsApp = new StudentsApp();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            Menu.displayMenu();
            System.out.println("Enter your choice :");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Menu.viewStudents(studentsApp);
                    break;
                case 2:
                    Menu.addStudent(studentsApp);
                    break;
                case 3:
                    Menu.editStudent(studentsApp);
                    break;
                case 4:
                    Menu.deleteStudent(studentsApp);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Please check your choice!");
            }
        } while (choice != 0);

        input.close();
    }
}