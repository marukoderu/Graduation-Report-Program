import error.InvalidStudentID;
import students.Students;
import students.StudentsApp;
import util.GraduateStatusUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void displayMenu() {
        System.out.println("=============================");
        System.out.println("WELCOME TO GRADUATE REPORT");
        System.out.println("Program untuk mengetahui status kelulusan \nBerdasarkan nilai");
        System.out.println("=============================");
        System.out.println("1. Lihat Daftar Mahasiswa");
        System.out.println("2. Tambah Data Mahasiswa");
        System.out.println("3. Edit Data Mahasiswa");
        System.out.println("4. Hapus Data Mahasiswa");
        System.out.println("0. Exit");
    }

    public static void viewStudents(StudentsApp studentsApp) {
        ArrayList<Students> Students = new ArrayList<>();
        studentsApp.viewStudents(Students);
    }

    public static void addStudent(StudentsApp studentsApp) {
        Scanner input = new Scanner(System.in);
        boolean isValidID = false;
        String studentID = "";

        System.out.println("Tambah Data Mahasiswa");

        do {
            System.out.println("NIM:");
            studentID = input.nextLine();
            try {
                InvalidStudentID.validateStudentID(studentID);
                isValidID = true;
            } catch (InvalidStudentID e) {
                System.out.println("\u001B[33m" + e.getMessage() + "\u001B[0m");
            }
        } while (!isValidID);


        System.out.println("Nama:");
        String studentName = input.nextLine();

        System.out.println("Kelas:");
        String studentClass = input.nextLine();

        System.out.println("Jurusan:");
        String studentDepartment = input.nextLine();

        ArrayList<Integer> scores = new ArrayList<>();
        System.out.println("Nilai Mahasiswa (masukkan nilai angka):");
        int score;
        int i = 1;
        while (true) {
            System.out.println("Nilai ke-" + i + ":");
            score = input.nextInt();
            if (score == -1) {
                break;
            }
            i++;
            scores.add(score);
        }

        String averageScore = GraduateStatusUtil.scoreAverage(scores);

        String graduateStatus = GraduateStatusUtil.graduateStatus(averageScore);

        Students student = new Students(studentID, studentName, studentClass, studentDepartment, averageScore, graduateStatus);
        for (int s : scores) {
            student.addScore(s);
        }
        studentsApp.addStudents(student);

    }

    public static void editStudent(StudentsApp studentsApp) {
        Scanner input = new Scanner(System.in);
        int choice;
        boolean isValidChoice = false;

        ArrayList<Students> Students = new ArrayList<>();
        studentsApp.viewStudents(Students);

        System.out.println("Pilih NIM Mahasasiswa yang ingin di edit!");
        String taskID = input.nextLine();

        Students studentToEdit = studentsApp.findStudentByID(taskID);
        System.out.println(studentToEdit);

        do {
            if (studentToEdit != null) {
                System.out.println("1. Edit Name");
                System.out.println("2. Edit Kelas");
                System.out.println("3. Edit Jurusan");
                System.out.println("4. Edit Nilai");
                System.out.println("0. Selesai");
                System.out.println("Pilih apa yang ingin di edit:");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        input.nextLine();
                        System.out.println("Nama baru:");
                        String newName = input.nextLine();
                        studentToEdit.setStudentName(newName);
                        break;
                    case 2:
                        input.nextLine();
                        System.out.println("Kelas baru:");
                        String newClass = input.nextLine();
                        studentToEdit.setStudentClass(newClass);
                        break;
                    case 3:
                        input.nextLine();
                        System.out.println("Jurusan baru:");
                        String newDep = input.nextLine();
                        studentToEdit.setStudentDepartment(newDep);
                        break;
                    case 4:
                        editScores(studentToEdit, input);
                        break;
                    case 0:
                        System.out.println("Kembali ke menu awal...");
                        isValidChoice = true;
                        break;
                    default:
                        System.out.println("Pilihan menu mu tidak tersedia!");
                }
            } else {
                System.out.println("Data Mahasiswa tidak ditemukan!");
            }
        } while (!isValidChoice);
    }

    public static void editScores(Students students, Scanner input) {
        System.out.println("Daftar nilai saat ini: " + students.getScores());
        input.nextLine();
        ArrayList<Integer> scores = new ArrayList<>();
        int score;

        while (true) {
            System.out.println("Masukkan nilai baru: ");
            score = input.nextInt();
            if (score == -1) {
                break;
            }
            scores.add(score);
        }
        students.setScores(scores);

        String averageScore = GraduateStatusUtil.scoreAverage(scores);
        students.setScoreAverage(averageScore);

        String graduateStatus = GraduateStatusUtil.graduateStatus(averageScore);
        students.setIsGraduate(graduateStatus);
    }

    public static void deleteStudent(StudentsApp studentsApp) {
        Scanner input = new Scanner(System.in);
        int choice;

        ArrayList<Students> Students = new ArrayList<>();
        studentsApp.viewStudents(Students);

        System.out.println("Pilih NIM Mahasiswa yang ingin di hapus!");
        String taskID = input.nextLine();

        Students studentToDelete = studentsApp.findStudentByID(taskID);
        System.out.println(studentToDelete);

        if (studentToDelete != null) {
            studentsApp.deleteStudents(studentToDelete);
            System.out.println("Data Mahasiswa berhasil di hapus.");
        } else {
            System.out.println("Data Mahasiswa tidak ditemukan!");
        }
    }
}
