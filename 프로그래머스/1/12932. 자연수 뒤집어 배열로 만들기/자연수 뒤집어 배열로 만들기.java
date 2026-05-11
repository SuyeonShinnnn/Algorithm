import java.util.*;

class Solution {
    public Deque<Long> solution(long n) {
        int len = Long.toString(n).length();
        Deque<Long> result = new ArrayDeque<>();
      
        for(int i = len - 1; i >= 0; i--) {
            int num = (int)Math.pow(10, i);
            result.addFirst(n / num);
            n %= num;
        }
        
        return result;
    }
}