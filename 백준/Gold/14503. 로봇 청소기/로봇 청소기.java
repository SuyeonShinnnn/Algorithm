import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private final int[] goX = {-1, 0, 1, 0};
    private final int[] goY = {0, 1, 0, -1};
    private final int[] backX = {1, 0, -1, 0};
    private final int[] backY = {0, -1, 0, 1};

    private int n;
    private int m;
    private int[][] map;
    private Queue<int[]> q;

    public Main(int n, int m) {
        this.n = n;
        this.m = m;
        map = new int[n][m];
        q = new LinkedList<>();
    }

    public void initMap(int[][] map) { this.map = map; }

    public boolean isFullCleanedUp(int[] curr) {
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int nx = curr[1] + goX[i];
            int ny = curr[2] + goY[i];

            if(map[nx][ny] != 0) count++;
        }
        if(count == 4) return true;
        return false;
    }
    public int cleanUp(int x, int y, int d) {
        q.offer(new int[]{d, x, y});

        int count = 0;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(map[curr[1]][curr[2]] == 0) {
                map[curr[1]][curr[2]] = 2;
                count++;
            }

            if(isFullCleanedUp(curr)) {
                int nextX = curr[1] + backX[curr[0]];
                int nextY = curr[2] + backY[curr[0]];

                if(map[nextX][nextY] == 1) return count;
                q.offer(new int[]{curr[0], nextX, nextY});

                continue;
            }

            int nextDir = (curr[0] + 3) % 4;
            int nextX = curr[1] + goX[nextDir];
            int nextY = curr[2] + goY[nextDir];

            if(map[nextX][nextY] == 0) {
                q.offer(new int[]{nextDir, nextX, nextY});
                continue;
            }
            q.offer(new int[]{nextDir, curr[1], curr[2]});

        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Main main = new Main(n, m);

        input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]);

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        main.initMap(map);
        int answer = main.cleanUp(x, y, d);

        System.out.println(answer);
    }
}