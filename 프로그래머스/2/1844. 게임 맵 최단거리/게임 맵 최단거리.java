import java.util.*;

class Solution {
    private final int[] moveX = {1, -1, 0, 0};
    private final int[] moveY = {0, 0, 1, -1};
    private int n;
    private int m;
    
    public int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            if(curr[0] == n - 1 && curr[1] == m - 1) return maps[n - 1][m - 1];
            
            for(int i = 0; i < 4; i++) {
                int nextX = curr[0] + moveX[i];
                int nextY = curr[1] + moveY[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                
                if(maps[nextX][nextY] == 1) {
                    maps[nextX][nextY] = maps[curr[0]][curr[1]] + 1;
                    q.offer(new int[] {nextX, nextY});
                }
            }
        }
        return -1;
    }
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return bfs(maps);
    }
}