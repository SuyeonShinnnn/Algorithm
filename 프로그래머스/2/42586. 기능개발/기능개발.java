import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> solution(int[] progresses, int[] speeds) {
        for(int i = 0; i < progresses.length; i++) {
            int curr = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            list.add(curr);
        }
        
        int prevMax = list.get(0);
        int count = 0;
        List<Integer> answer = new ArrayList<>();
        for(int curr: list) {
            if(prevMax >= curr) {
                
                count++;
                continue;
            }
            prevMax = Math.max(prevMax, curr);
            answer.add(count);
            count = 1;
        }
        answer.add(count);    
        
        return answer;
    }
}