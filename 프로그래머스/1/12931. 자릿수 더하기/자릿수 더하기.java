import java.util.*;

public class Solution {
    public int solution(int n) {
        int len = Integer.toString(n).length();
        int sum = 0;
        
        for(int i = len - 1; i > 0; i--) {
            int num = (int)Math.pow(10, i);
            sum += n / num;
            n %= num;
            System.out.println(sum + " " + num + " " + n);
        }
        
        return sum + n;
    }
}