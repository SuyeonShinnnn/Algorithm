import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int i = 0;
      
        for(int[] b: balls) {
            // 1 -1 -2 2
            // 상하좌우
            int [][] flex = {{b[0], n - b[1] + n, 1}, {b[0], -b[1], -1}, 
                             {-b[0], b[1], -2}, {m - b[0] + m, b[1], 2}};
            
            int min = Integer.MAX_VALUE;
            for(int[] f: flex) {
                if((f[2] == 1 && (b[0] == startX && b[1] > startY)) ||
                  (f[2] == -1 && (b[0] == startX && b[1] < startY)) ||
                  (f[2] == -2 && (b[1] == startY && b[0] < startX)) ||
                  (f[2] == 2 && (b[1] == startY && b[0] > startX))) {
                    continue;
                }
              
                int dist = (int)Math.pow(startX - f[0], 2) + (int)Math.pow(startY - f[1], 2);
                min = Math.min(min, dist);
            }
            answer[i] = min;
            i++;
        }
        return answer;
    }
}