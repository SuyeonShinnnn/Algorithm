import java.util.*;

class Solution {
    private int[][] map;
    private int[] dist;
    
    public void dfs(int v, int n) {
        
        for(int i = 0; i < n; i++) {
            if(dist[i] > dist[v] + map[v][i] && map[v][i] != Integer.MAX_VALUE) {
                dist[i] = dist[v] + map[v][i];
                dfs(i, n);
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        map = new int[N][N];
        dist = new int[N];
        
        for(int i = 0; i < N; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int[] r: road) {
            int s = r[0] - 1;
            int e = r[1] - 1;
            
            map[s][e] = Math.min(map[s][e], r[2]);
            map[e][s] = Math.min(map[e][s], r[2]);
        }
        
        dist[0] = 0;
        dfs(0, N);
        
        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
}