import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        
        int[] curr = {0, 0};
        int[] next = {0, 0};
        
        for(int i = 0; i < dirs.length(); i++) {
            char currDirs = dirs.charAt(i);
            String moved = curr[0] + "," + curr[1];
            
            if(currDirs == 'U') next[1] = curr[1] + 1;
            else if(currDirs == 'R') next[0] = curr[0] + 1;
            else if(currDirs == 'D') next[1] = curr[1] - 1;
            else if(currDirs == 'L') next[0] = curr[0] - 1;
            
            if(next[0] > 5 || next[0] < -5 || next[1] > 5 || next[1] < -5) {
                next = curr.clone();
                continue;
            }
            
            visited.add(next[0] + "," + next[1] + "," + moved);
            visited.add(moved + "," + next[0] + "," + next[1]);
            curr = next.clone();
        }
        return visited.size() / 2;
    }
}