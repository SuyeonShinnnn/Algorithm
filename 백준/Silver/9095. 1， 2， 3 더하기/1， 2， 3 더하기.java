import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static int dp(int n) {
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) arr[i] = 1;
            else if (i == 2) arr[i] = 2;
            else if (i == 3) arr[i] = 4;
            else arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int answer = dp(num);
            System.out.println(answer);
        }
    }
}