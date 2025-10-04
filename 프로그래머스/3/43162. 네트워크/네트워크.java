import java.util.*;

class Solution {
    private boolean[] visited;
    private Queue<Integer> q;
    
    public void runBFS(int s, int[][] computers) {
        visited[s] = true;
        q.offer(s);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int i = 0; i < computers.length; i++) {
                if(!visited[i] && computers[curr][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        q = new LinkedList<>();
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                runBFS(i, computers);
                answer++;
            }
        }
        return answer;
    }
}