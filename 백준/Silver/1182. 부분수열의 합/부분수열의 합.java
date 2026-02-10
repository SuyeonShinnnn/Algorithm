import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int s;
    static int[] nums;
    static int count = 0;

    public static void dfs(int idx, int depth, int sum, boolean[] visited) {
        if ((depth == n || sum == s) && depth != 0) {
            if (depth == n && sum != s) return;
            if (depth == n && sum == s) {
                count++;
                return;
            }
            if(depth != n && sum == s) {
                count++;
            }
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1, sum + nums[i], visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        dfs(0, 0, 0, new boolean[n]);
        System.out.println(count);
    }
}