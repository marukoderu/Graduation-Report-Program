package error;

import java.util.Scanner;

public class UnknownMenuInput extends Throwable {
    public UnknownMenuInput(String message) {
        super(message);
    }

    public static int readIntegerInput(Scanner input) throws UnknownMenuInput {
        if (input.hasNextInt()) {
            return input.nextInt();
        } else {
            input.next();
            throw new UnknownMenuInput("Tolong masukan nomor menu yang valid!");
        }
    }
}
