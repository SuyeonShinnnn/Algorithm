import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] w;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int start, int curr, int depth, int dist, boolean[] visited) {
        if (depth == n - 1) {
            if (w[curr][start] != 0) {
                min = Math.min(min, dist + w[curr][start]);
            }
            return;
        }

        visited[start] = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && w[curr][i] != 0) {
                visited[i] = true;
                dfs(start, i, depth + 1, dist + w[curr][i], visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        w = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, 0, 0, new boolean[n]);
        }
        System.out.println(min);
    }
}