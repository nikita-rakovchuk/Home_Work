import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("INPUT.txt"));

        int[] storage = new int[scanner.nextInt()];
        int i = 0;
        int sum = 0, multiplication = 1;
        while (scanner.hasNext()) {
            int tmp = scanner.nextInt();
            if (tmp > 0) {
                storage[i++] = tmp;
                sum += tmp;
            } else {
                storage[i++] = tmp;
            }
        }
        int position_min = 0, position_max = 0;
        int min_number = storage[0], max_number = storage[0];

        for (int j = 0; j < storage.length; j++) {
            if (min_number > storage[j]) {
                min_number = storage[j];
                position_min = j;
            }
            if (max_number < storage[j]) {
                max_number = storage[j];
                position_max = j;
            }
        }
        if (position_min > position_max) {
            int tmp = position_min;
            position_min = position_max;
            position_max = tmp;
        }
        for (int h = position_min + 1; h < position_max; h++) {
            multiplication *= storage[h];
        }

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OUTPUT.txt"), "UTF-8"));
        out.write(Integer.toString(sum) + " " + Integer.toString(multiplication));
        out.close();
    }
}
