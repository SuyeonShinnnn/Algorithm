import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static final int[] moveX = {1, -1, 0, 0};
    static final int[] moveY = {0, 0, 1, -1};
    static int max;

    public static void dfs(int r, int c, char[][] map, int count, int x, int y, Set<Character> visited) {
        if(max < count) max = count;

        for(int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if(nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) continue;
            if(visited.contains(map[nextX][nextY])) continue;

            visited.add(map[nextX][nextY]);
            dfs(r, c, map, count + 1, nextX, nextY, visited);
            visited.remove(map[nextX][nextY]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String mapInput = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = mapInput.charAt(j);
            }
        }
        Set<Character> visited = new HashSet<>();
        visited.add(map[0][0]);

        dfs(r, c, map,1, 0, 0, visited);
        System.out.println(max);
    }
}