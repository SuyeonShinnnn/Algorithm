import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int n;
    static int m;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();

    public static void dfs(int depth, int[] arr, boolean[] visited) {
        if (depth == m) {
            String str = Arrays.toString(arr);
            if (!set.contains(str)) {
                for (int a : arr) {
                    sb.append(a + " ");
                }
                sb.append("\n");
                set.add(str);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = nums[i];
            dfs(depth + 1, arr, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);

        dfs(0, new int[m], new boolean[n]);
        System.out.println(sb);
    }
}