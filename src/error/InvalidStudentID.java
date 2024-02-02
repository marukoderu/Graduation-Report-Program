package error;

public class InvalidStudentID extends Exception {
    public InvalidStudentID(String message) {
        super(message);
    }

    public static void validateStudentID(String input) throws InvalidStudentID {
        if (input.length() > 12) {
            throw new InvalidStudentID("NIM Mahasiswa terdiri dari 12 karakter!");
        }
    }
}
