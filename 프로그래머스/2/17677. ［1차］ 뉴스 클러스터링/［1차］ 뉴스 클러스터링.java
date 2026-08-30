import java.util.*;

class Solution {
    private final int MUL = 65536;
    private Map<String, Integer> set1 = new HashMap<>();
    private Map<String, Integer> set2 = new HashMap<>();
    
    public void initSet(String str, Map<String, Integer> set) {
        str = str.toLowerCase();
        
        for(int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            
            if('a' <= a && a <= 'z' && 'a' <= b && b <= 'z') {
                String s = String.valueOf(a) + b;
                int count = set.getOrDefault(s, 0);
                set.put(s, count + 1);
            }
        }
    }
    
    public int solution(String str1, String str2) {
        initSet(str1, set1);
        initSet(str2, set2);
        
        int union = 0;
        int intersect = 0;
        for(String key: set1.keySet()) {
            int cnt1 = set1.get(key);
            int cnt2 = set2.getOrDefault(key, 0);
            
            set2.remove(key);

            union += Math.max(cnt1, cnt2);
            intersect += Math.min(cnt1, cnt2);
        }
        for(String key: set2.keySet()) {
            union += set2.get(key);
        }
        
        if(union == 0) return MUL;
        
        double sum = (double)intersect / union;
        return (int)(sum * (double)MUL);
    }
}