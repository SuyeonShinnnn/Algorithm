import java.util.*;

class Solution {
    
    private int n;
    private List<String> result = new ArrayList<>();
    
    public void dfs(int depth, String path, String[][] t, String start, boolean[] visited) {
        if(depth == n) {
            result.add(path);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(start.equals(t[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(depth + 1, path + " " + t[i][1], t, t[i][1], visited);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        
        dfs(0, "ICN", tickets, "ICN", new boolean[n]);
        Collections.sort(result);
        
        return result.get(0).split(" ");
    }
}