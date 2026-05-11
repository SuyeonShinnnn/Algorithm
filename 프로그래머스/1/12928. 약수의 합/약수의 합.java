import java.util.*;

class Solution {
    Set<Integer> s = new HashSet<>();
    
    public int solution(int n) {
        int sum = 0;
        
        for(int i = 1; i <= n; i++) {
            if(n % i  == 0 && !s.contains(i)) {
                s.add(i);
                sum += i;
            }
        }
        return sum;
    }
}