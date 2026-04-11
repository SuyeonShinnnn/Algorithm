import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;

    static final int[] moveX = {1, -1, 0, 0};
    static final int[] moveY = {0, 0, 1, -1};

    static StringBuilder sb = new StringBuilder();

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);

            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) result[i][j] = 0;
            }
        }

        result[x][y] = 0;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + moveX[i];
                int nextY = curr[1] + moveY[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m
                        && !visited[nextX][nextY] && map[nextX][nextY] != 0) {
                    q.offer(new int[]{nextX, nextY, curr[2] + 1});
                    result[nextX][nextY] = curr[2] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x, y);

        System.out.println(sb);
    }
}