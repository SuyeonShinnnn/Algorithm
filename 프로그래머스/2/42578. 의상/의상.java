import java.util.*;

class Solution {
    private Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        for(String[] c: clothes) {
            int count = map.getOrDefault(c[1], 0);
            map.put(c[1], count + 1);
        }

        int answer = 1;
        
        for(int v: map.values()) {
            answer *= (v + 1);
        }
    

        return answer - 1;
    }
}