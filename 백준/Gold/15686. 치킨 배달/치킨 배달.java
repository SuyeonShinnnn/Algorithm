import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int result;

    public static void dfs(List<int[]> store, List<int[]> house, boolean[][] visited, int storeCount, int start) {
        if (storeCount == m) {
            int dist = 0;
            for(int i = 0; i < house.size(); i++) {
                int minDist = Integer.MAX_VALUE;
                int[] h = house.get(i);
                for (int j = 0; j < store.size(); j++) {
                    int[] s = store.get(j);
                    if (visited[s[0]][s[1]]) {
                        minDist = Math.min(minDist, Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]));
                    }
                }
                dist += minDist;
            }
            result = Math.min(result, dist);
            return;
        }

        for(int i = start; i < store.size(); i++) {
            int[] s = store.get(i);
            if(!visited[s[0]][s[1]]) {
                visited[s[0]][s[1]] = true;
                dfs(store, house, visited, storeCount + 1, i + 1);
                visited[s[0]][s[1]] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        List<int[]> store = new ArrayList<>();
        List<int[]> house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 2) {
                    store.add(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    house.add(new int[]{i, j, Integer.MAX_VALUE});
                }
            }
        }

        result = Integer.MAX_VALUE;
        dfs(store, house, visited, 0, 0);
        System.out.println(result);
    }
}