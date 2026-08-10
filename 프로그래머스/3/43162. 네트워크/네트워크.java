import java.util.*;

class Solution {
    private boolean[] visited;
    
    public void bfs(int n, int node, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int i = 0; i < n; i++) {
                if(!visited[i] && computers[curr][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(n, i, computers);
                answer++;
            }
        }
        
        return answer;
    }
}