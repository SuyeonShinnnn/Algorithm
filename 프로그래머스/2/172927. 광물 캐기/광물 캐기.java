import java.util.*;

class Solution {
    private Map<String, int[]> fatigability;
    private int min = Integer.MAX_VALUE;
    
    public void dfs(String[] minerals, int[] picks, int idx, int result) {
        if(idx >= minerals.length || picks[0] + picks[1] + picks[2] == 0) {
            min = Math.min(result, min);
            return;
        }
       
        if(picks[0] > 0) {
            picks[0]--;
            
            int sum = getFatigue(minerals, idx, 0);
            dfs(minerals, picks, idx + 5, result + sum);
            
            picks[0]++;
        }
        if(picks[1] > 0) {
            picks[1]--;
            
            int sum = getFatigue(minerals, idx, 1);
            dfs(minerals, picks, idx + 5, result + sum);
            
            picks[1]++;
        }
        if(picks[2] > 0) {
            picks[2]--;
            
            int sum = getFatigue(minerals, idx, 2);
            dfs(minerals, picks, idx + 5, result + sum);
            
            picks[2]++;
        }
    }
    
    public int getFatigue(String[] minerals, int idx, int tool) {
        int sum = 0;
        for(int i = idx; i < idx + 5 && i < minerals.length; i++) {
            sum += fatigability.get(minerals[i])[tool];
        }
        return sum;
    }
    public int solution(int[] picks, String[] minerals) {
        fatigability = new HashMap<>();
        fatigability.put("diamond", new int[] {1, 5, 25});
        fatigability.put("iron", new int[] {1, 1, 5});
        fatigability.put("stone", new int[] {1, 1, 1});
        
        dfs(minerals, picks, 0, 0);
        
        return min;
    }
}