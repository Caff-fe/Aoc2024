import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int safeCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int[] levels = Arrays.stream(line.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (isSafe(levels)) {
                    safeCount++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }

        System.out.println("Number of safe reports: " + safeCount);
    }

    private static boolean isSafe(int[] levels) {

        boolean increasing = levels[0] < levels[1];
        boolean valid = true;

        for (int i = 0; i < levels.length - 1; i++) {
            int differrence = levels[i + 1] - levels[i];
            if (differrence == 0 || Math.abs(differrence) > 3) {
                valid = false;
                break;
            }
            if (increasing && differrence < 0) {
                valid = false;
                break;
            }
            if (!increasing && differrence > 0) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}