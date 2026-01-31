import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int[] nums;
    static StringBuilder sb;

    public static void dfs(int depth, int[] arr) {
        if (depth == m) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = nums[i];
            dfs(depth + 1, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        nums = new int[n];

        input = br.readLine().split(" ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);

        dfs(0, new int[m]);
        System.out.println(sb);
    }
}