import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long dp(int n, int m) {
        long[][] arr = new long[n + 1][m + 1];

        if (n == 0) return 1;
        else if (n == 1) return m;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    arr[i][j] = 1;
                } else if (i != 0 && i > j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i][j - 1];
                }
            }
        }
        return arr[n][m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            long answer = dp(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            System.out.println(answer);
        }
    }
}