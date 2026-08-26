import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) return Integer.compare(a[2], b[2]);
                
                return Integer.compare(a[1], b[1]);
            }
            else {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        int time = 0;
        int sum = 0;
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        while(count < jobs.length) {
            for(int i = 0; i < jobs.length; i++) {
                if(time >= jobs[i][0] && !visited.contains(i)) {
                    pq.offer(new int[] {jobs[i][1], jobs[i][0], i});
                    visited.add(i);
                }
            }
            
            if(pq.isEmpty()) {
                time++;
                continue;
            }
            
            int[] curr = pq.poll();
            
            time += curr[0];
            sum += time - curr[1];
            
            count++;
        }
        return sum / jobs.length;
    }
}