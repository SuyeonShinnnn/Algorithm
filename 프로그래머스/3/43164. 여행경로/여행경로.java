import java.util.*;

class Solution {
    
    public boolean dfs(String curr, List<String> result, boolean[] visited, String[][] tickets) {
        if(result.size() - 1== tickets.length) {
            return true;
        }
            
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && curr.equals(tickets[i][0])) {
                visited[i] = true;
                result.add(tickets[i][1]);
                
                if(dfs(tickets[i][1], result, visited, tickets)) return true;
                
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
        return false;
    }
    public List<String> solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        List<String> result = new ArrayList<>();
        result.add("ICN");
        
        dfs("ICN", result, new boolean[tickets.length], tickets);
        
        return result;
    }
}