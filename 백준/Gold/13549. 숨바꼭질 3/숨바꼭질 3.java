import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static final int MAX = 100000;

    public static int bfs(int n, int k) {
        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});
        visited[n] = true;

        int min = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            visited[curr[0]] = true;

            if (curr[0] == k) {
                min = Math.min(min, curr[1]);
            }

            if (curr[0] * 2 <= MAX && !visited[curr[0] * 2]) {
                q.offer(new int[]{curr[0] * 2, curr[1]});
            }
            if (curr[0] + 1 <= MAX && !visited[curr[0] + 1]) {
                q.offer(new int[]{curr[0] + 1, curr[1] + 1});
            }
            if (curr[0] - 1 >= 0 && !visited[curr[0] - 1]) {
                q.offer(new int[]{curr[0] - 1, curr[1] + 1});
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        System.out.println(bfs(n, k));
    }
}