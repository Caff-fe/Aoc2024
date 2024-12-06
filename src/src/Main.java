import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] tempArr;

        List<Integer> leftList = new ArrayList<>();

        List<Integer> rightList = new ArrayList<>();

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while (line != null) {
                tempArr = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                leftList.add(tempArr[0]);
                rightList.add(tempArr[1]);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        int sum = 0;

        for (int i = 0; i < leftList.size(); i++) {
            int num = Collections.frequency(rightList, leftList.get(i));
            sum += num * leftList.get(i);
        }

        System.out.println(sum);
    }
}