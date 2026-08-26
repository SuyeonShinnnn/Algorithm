import java.util.*;

class Solution {
    private int[][] map;
    private Set<Integer> visited;
    private PriorityQueue<int[]> pq;
    
    public int solution(int n, int[][] costs) {
        map = new int[n][n];
        visited = new HashSet<>();
        
        for(int c[] : costs) {
            map[c[0]][c[1]] = c[2];
            map[c[1]][c[0]] = c[2];
        }
        pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] {0, 0});
        
        int answer = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            if(visited.contains(curr[0])) continue;
            
            visited.add(curr[0]);
            answer += curr[1];
            
            if(visited.size() == n) {
                return answer;
            }
            
            for(int i = 0; i < n; i++) {
                if(map[curr[0]][i] != 0 && !visited.contains(i)) {
                    pq.offer(new int[] {i, map[curr[0]][i]});
                }
            }
        }
        return answer;
    }
}