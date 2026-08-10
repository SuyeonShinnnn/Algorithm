import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(numbers[0]);
        q.offer(-numbers[0]);
        
        
        for(int i = 1; i < numbers.length; i++) {
            for(int j = 0; j < Math.pow(2, i); j++) {
                int curr = q.poll();
                q.offer(curr + numbers[i]);
                q.offer(curr - numbers[i]);
            }
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            if(curr == target) answer++;
        }
        return answer;
    }
}