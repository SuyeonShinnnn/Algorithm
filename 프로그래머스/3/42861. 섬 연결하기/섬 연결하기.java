import java.util.*;

class Solution {
    
    private int[][] map;
    
    public int bfs(int n) {
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        Set<Integer> visited = new HashSet<>();
        
        pq.offer(new int[]{0, 0});
        visited.add(0);
        
        int dist = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            if(!visited.contains(curr[0])) {
                visited.add(curr[0]);
                dist += curr[1];
            }
            
            if(visited.size() == n) return dist;
            
            for(int i = 0; i < n; i++) {
                if(!visited.contains(i) && map[curr[0]][i] != 0) {
                    pq.offer(new int[] {i, map[curr[0]][i]});
                }
            }
        }
        return dist;
    }
    public int solution(int n, int[][] costs) {
        map = new int[n][n];
        for(int[] c: costs) {
            map[c[0]][c[1]] = c[2];
            map[c[1]][c[0]] = c[2];
        }
        return bfs(n);
    }
}