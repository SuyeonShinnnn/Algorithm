import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(input[i]);

            if (i == 0) {
                arr[0][1] = arr[0][0];
                continue;
            }
            arr[i][1] = arr[i - 1][1] + arr[i][0];
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]) - 1;

            if (s - 1 < 0) {
                sb.append(arr[e][1] + "\n");
                continue;
            }
            sb.append(arr[e][1] - arr[s - 1][1] + "\n");
        }
        System.out.println(sb);
    }
}