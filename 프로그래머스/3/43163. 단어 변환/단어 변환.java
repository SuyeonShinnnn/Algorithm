import java.util.*;

class Solution {
    Queue<int[]> q = new LinkedList<>();
    
    public boolean checkDiff(String a, String b) {
        int count = 0;
        
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        if(count == 1) {
            return true;
        }
        return false;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        
        for(int i = 0; i < words.length; i++) {
            if(checkDiff(begin, words[i])) {
                q.add(new int[]{i, 1});
            }
        }
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currIdx = curr[0];
            int currCnt = curr[1];
            visited[currIdx] = true;
            
            System.out.println(words[currIdx] + " " + currCnt);
            
            if(words[currIdx].equals(target)){
                return currCnt;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && checkDiff(words[currIdx], words[i])) {
                    q.offer(new int[]{i, currCnt + 1});
                    visited[i] = true;
                }
            }
        }
        
        return answer;
    }
}