
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int runDP(int n, int[] stairs) {
        if(n == 0) return 0;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) dp[0] = stairs[0];
            else if(i == 1) dp[1] = stairs[1] + dp[0];
            else if(i == 2) dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
            else if(i >= 3){
                dp[i] = Math.max(dp[i - 2] + stairs[i], stairs[i - 1] + dp[i - 3] + stairs[i]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] stairs = new int[t];
        for(int i = 0; i < t; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int answer = runDP(t, stairs);
        System.out.println(answer);
    }
}