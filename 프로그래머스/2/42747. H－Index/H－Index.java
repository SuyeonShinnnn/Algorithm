import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        for(int i = n - 1; i >= 0; i--) {
            if(citations[n - i - 1] >= i + 1) {
                return i + 1;
            }
        }
        
        int answer = 0;
        return answer;
    }
}