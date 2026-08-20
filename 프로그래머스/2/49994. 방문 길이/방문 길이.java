import java.util.*;

class Solution {
    private String makePath(int x1, int y1, int x2, int y2) {
    StringBuilder sb = new StringBuilder();

    sb.append(x1)
      .append(",")
      .append(y1)
      .append(",")
      .append(x2)
      .append(",")
      .append(y2);

    return sb.toString();
}
    
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        
        int[] curr = {0, 0};
        int[] next = {0, 0};
        
        for(int i = 0; i < dirs.length(); i++) {
            char currDirs = dirs.charAt(i);
            
            switch(currDirs) {
                case 'U': 
                    next[1] = curr[1] + 1;
                    break;
                case 'R': 
                    next[0] = curr[0] + 1;
                    break;
                case 'D': 
                    next[1] = curr[1] - 1;
                    break;
                default: 
                    next[0] = curr[0] - 1;
                    break;
            }
            
            if(next[0] > 5 || next[0] < -5 || next[1] > 5 || next[1] < -5) {
                next = curr.clone();
                continue;
            }
            
            visited.add(makePath(next[0], next[1], curr[0], curr[1]));
            visited.add(makePath(curr[0], curr[1], next[0], next[1]));
            curr = next.clone();
        }
        return visited.size() / 2;
    }
}