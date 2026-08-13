import java.util.*;

class Solution {
    private boolean[][] map;
    private int[] dist;
    private boolean[] visited;
    
    public void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        dist[0] = 0;
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int i = 0; i < n; i++) {
                if(map[curr][i] && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    dist[i] = dist[curr] + 1;
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        map = new boolean[n][n];
        dist = new int[n];
        visited = new boolean[n];
        
        for(int i = 0; i < edge.length; i++) {
            int s = edge[i][0] - 1;
            int e = edge[i][1] - 1;
            
            map[s][e] = true;
            map[e][s] = true;
        }
        
        bfs(n);
        
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(max < dist[i]) {
                max = dist[i];
                count = 0;
            }
            if(max == dist[i]) count++;
        }
        
        return count;
    }
}