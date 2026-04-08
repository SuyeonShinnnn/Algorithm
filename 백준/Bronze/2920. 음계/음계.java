import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        boolean isAscending = false;

        for (int i = 0; i < input.length - 1; i++) {
            int curr = Integer.parseInt(input[i]);
            int next = Integer.parseInt(input[i + 1]);

            if (curr < next) {
                isAscending = true;
                continue;
            }

            if (curr > next && isAscending) {
                System.out.println("mixed");
                return;
            }
        }
        if (isAscending) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}