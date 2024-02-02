import error.UnknownMenuInput;
import students.Students;
import students.StudentsApp;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentsApp studentsApp = new StudentsApp();
        Scanner input = new Scanner(System.in);
        int choice;

        boolean isValidChoice = false;

        do {
            try {
                Menu.displayMenu();
                System.out.println("Pilih nomor menu:");
                choice = UnknownMenuInput.readIntegerInput(input);

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
                        isValidChoice = true;
                        break;
                    default:
                        System.out.println("Pilihan menu mu tidak tersedia!");
                }
            } catch (UnknownMenuInput e) {
                System.err.println(e.getMessage());
                input.nextLine();
            }
        } while (!isValidChoice);

        input.close();
    }
}