import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private int m;
    private int n;
    private int[][] box;
    private Queue<int[]> q;
    private int[] moveX = {1, -1, 0, 0};
    private int[] moveY = {0, 0, 1, -1};

    public Main(int m, int n) {
        this.m = m;
        this.n = n;
        this.box = new int[n][m];
        this.q = new LinkedList<>();
    }

    public void initBox(BufferedReader br) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) q.offer(new int[]{i, j});
            }
        }
    }

    public void runBFS() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = curr[0] + moveX[i];
                int nextY = curr[1] + moveY[i];

                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m
                        && box[nextX][nextY] == 0) {
                    q.offer(new int[] {nextX, nextY});
                    box[nextX][nextY] = box[curr[0]][curr[1]] + 1;
                }
            }
        }
    }

    public int getResult() {
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 0) return -1;
                else if(max < box[i][j]) {
                    max = box[i][j];
                }
            }
        }
        return max - 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Main main = new Main(m, n);
        main.initBox(br);
        main.runBFS();

        System.out.println(main.getResult());
    }
}