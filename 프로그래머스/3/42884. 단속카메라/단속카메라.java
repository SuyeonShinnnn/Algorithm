import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        int minEnd = routes[0][1];
        int count = 1;
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] <= minEnd) {
                minEnd = Math.min(minEnd, routes[i][1]);
            }
            else if(routes[i][0] > minEnd) {
                count++;
                minEnd = Math.max(minEnd, routes[i][1]);
            }
        }
        
        return count;
    }
}
