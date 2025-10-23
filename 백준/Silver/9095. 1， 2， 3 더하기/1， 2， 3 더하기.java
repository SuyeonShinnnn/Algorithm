
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int runDP(int n) {
        if(n == 0) return 0;

        int[] dp = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            if(i == 1) dp[1] = 1;
            else if(i == 2) dp[2] = 2;
            else if(i == 3) dp[3] = 4;
            else if(i >= 4) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(runDP(input));
        }
    }
}