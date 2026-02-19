import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int dp(int n) {
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                arr[1] = 1;
            } else if (i == 2) {
                arr[2] = 2;
            } else {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
            }
        }
        return arr[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = dp(n);
        System.out.println(answer);
    }
}