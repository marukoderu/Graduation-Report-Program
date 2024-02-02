package util;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GraduateStatusUtil {
    public static String scoreAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return "0.0";
        }

        int total = 0;
        for (int score : scores) {
            total += score;
        }

        double avrg = (double) total / scores.size();

        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(avrg);
    }

    public static String graduateStatus(String scoreAvr) {
        double average = Double.parseDouble(scoreAvr);
        double minAvr = 75.00;

        if (average >= minAvr) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }
}
