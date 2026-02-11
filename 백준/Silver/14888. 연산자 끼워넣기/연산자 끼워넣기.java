import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int n;
    static int[] nums;
    static int[] ops;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void dfs(int depth, int sum, int idx, int[] visited) {
        if (depth == n - 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (visited[i] != ops[i]) {
                visited[i]++;
                if (i == 0) {
                    dfs(depth + 1, sum + nums[idx], idx + 1, visited);
                } else if (i == 1) {
                    dfs(depth + 1, sum - nums[idx], idx + 1, visited);
                } else if (i == 2) {
                    dfs(depth + 1, sum * nums[idx], idx + 1, visited);
                } else if (i == 3) {
                    dfs(depth + 1, (int) sum / nums[idx], idx + 1, visited);
                }
                visited[i]--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        n = Integer.parseInt(br.readLine());

        input = br.readLine().split(" ");
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        ops = new int[4];
        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(input[i]);
        }

        dfs(0, nums[0], 1, new int[4]);
        System.out.println(max);
        System.out.println(min);
    }
}