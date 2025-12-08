import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int bfs(int s, int e, int[][] tree, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});
        visited[s] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == e) return curr[1];

            for (int i = 1; i <= n; i++) {
                if (tree[curr[0]][i] != 0 && !visited[i]) {
                    q.offer(new int[]{i, curr[1] + tree[curr[0]][i]});
                    visited[i] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] tree = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);

            tree[s][e] = d;
            tree[e][s] = d;
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int result = bfs(Integer.parseInt(input[0]), Integer.parseInt(input[1]), tree, n);
            sb.append(result + "\n");
        }
        System.out.print(sb);
    }
}