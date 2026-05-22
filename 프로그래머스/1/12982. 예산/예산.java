import java.util.*;

class Solution {
    private int count = 0;
   
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        for(int i : d) {
            if(budget - i >= 0) {
                count++;
                budget -= i;
            }
        }
        
        return count;
    }
}