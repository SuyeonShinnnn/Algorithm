import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int m; // 가로 길이
    static int n; // 세로 길이
    static int k; // 배추가 심어져 있는 위치 개수
    static int count;
    static int[][] map;
    static boolean[][] visited;

    static final int[] moveN = {1, -1, 0, 0};
    static final int[] moveM = {0, 0, 1, -1};

    public static void bfs(int s, int e) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, e});
        visited[s][e] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextN = curr[0] + moveN[i];
                int nextM = curr[1] + moveM[i];

                if (nextN >= 0 && nextN < n && nextM >= 0 && nextM < m
                        && !visited[nextN][nextM] && map[nextN][nextM] == 1) {
                    q.offer(new int[]{nextN, nextM});
                    visited[nextN][nextM] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            t--;

            String[] input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);
            map = new int[n][m];
            visited = new boolean[n][m];
            count = 0;

            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                map[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}