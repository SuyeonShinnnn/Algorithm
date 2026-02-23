import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] nums;

    public static int dp(int n) {
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[0] = nums[0];
            } else {
                arr[i] = Math.max(arr[i - 1] + nums[i], nums[i]);
            }
            max = Math.max(arr[i], max);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int answer = dp(n);
        System.out.println(answer);
    }
}