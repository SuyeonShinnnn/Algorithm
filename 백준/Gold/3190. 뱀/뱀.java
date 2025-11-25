import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int time;
    static int n;
    static int[][] map;
    static List<String[]> direction;

    static final int[] mCol = {0, 1, 0, -1};
    static final int[] mRow = {-1, 0, 1, 0};

    public static int runDummy() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{1, 1});

        int currDir = 1;
        time = 0;

        for (String[] d : direction) {
            int after = Integer.parseInt(d[0]);
            while (true) {
                int[] currHead = dq.peekFirst();
                int nRow = currHead[0] + mRow[currDir];
                int nCol = currHead[1] + mCol[currDir];

                time += 1;
                if (nCol > n || nRow > n || nCol < 1 || nRow < 1) return time;

                if (map[nRow][nCol] == 1) {
                    return time;
                }

                if (map[nRow][nCol] != 2) {
                    int[] rm = dq.pollLast();
                    map[rm[0]][rm[1]] = 0;
                }

                dq.offerFirst(new int[]{nRow, nCol});
                map[nRow][nCol] = 1;

                if (time == after) {
                    if (d[1].equals("L")) currDir = (currDir + 3) % 4;
                    else if (d[1].equals("D")) currDir = (currDir + 1) % 4;
                    if (after != Integer.parseInt(direction.get(direction.size() - 1)[0])) break;
                }

            }
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 2;
        }

        map[1][1] = 1;


        int l = Integer.parseInt(br.readLine());
        direction = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            direction.add(br.readLine().split(" "));
        }

        System.out.println(runDummy());
    }
}