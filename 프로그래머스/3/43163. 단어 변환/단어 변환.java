import java.util.*;

class Solution {
    
    private int n;
    private int min = Integer.MAX_VALUE;
    
    public boolean isNext(String curr, String next) {
        int count = 0;
        
        for(int i = 0; i < curr.length(); i++) {
            if(curr.charAt(i) == next.charAt(i)) {
                count++;
            }
        }
        if(count == curr.length() - 1) return true;
        return false;
    }
    
    public void dfs(int count, boolean[] visited, String curr, String target, String[] words) {
        
        if(curr.equals(target)) {
            min = Math.min(min, count);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i] && isNext(curr, words[i])) {
                visited[i] = true;
                
                dfs(count + 1, visited, words[i], target, words);
                
                visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        dfs(0, new boolean[n], begin, target, words);
        
        if(min == Integer.MAX_VALUE) return 0;
        
        return min;
    }
}