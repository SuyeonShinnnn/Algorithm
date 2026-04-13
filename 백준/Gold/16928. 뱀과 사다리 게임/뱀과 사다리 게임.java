import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] dist;
    static Map<Integer, Integer> ladder;
    static Map<Integer, Integer> snake;
    static Queue<int[]> q;

    public static void moving(Map<Integer, Integer> map, int[] curr) {
        int moved = map.get(curr[0]);
        int row = moved / 10;
        int col = moved % 10;

        if (dist[row][col] > curr[1] + 1) {
            dist[curr[0] / 10][curr[0] % 10] = curr[1] + 1;
            dist[row][col] = curr[1] + 1;
            q.offer(new int[]{moved, curr[1] + 1});
        }
    }

    public static void bfs() {
        q = new LinkedList<>();
        dist[0][0] = 0;
        for (int i = 1; i <= 6; i++) {
            if (ladder.containsKey(i)) {
                moving(ladder, new int[]{i, 0});
            } else if (snake.containsKey(i)) {
                moving(snake, new int[]{i, 0});
            } else {
                q.offer(new int[]{i, 1});
                dist[0][i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = curr[0] + i;

                if (next >= 100) continue;

                if (ladder.containsKey(next)) {
                    moving(ladder, new int[]{next, curr[1]});
                } else if (snake.containsKey(next)) {
                    moving(snake, new int[]{next, curr[1]});
                } else if (curr[1] + 1 < dist[next / 10][next % 10]) {
                    q.offer(new int[]{next, curr[1] + 1});
                    dist[next / 10][next % 10] = curr[1] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 사다리 수
        int m = Integer.parseInt(input[1]); // 뱀의 수
        map = new int[10][10];
        dist = new int[10][10];
        ladder = new HashMap<>();
        snake = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            ladder.put(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
        }

        for (int j = 0; j < m; j++) {
            input = br.readLine().split(" ");
            ladder.put(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
        }

        bfs();
        System.out.println(dist[9][9]);
    }
}