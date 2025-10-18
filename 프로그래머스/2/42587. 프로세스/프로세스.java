import java.util.*;

class Solution {
    private PriorityQueue<Integer> pq;
    
    public Solution() {
        pq = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public int solution(int[] priorities, int location) {
        for(int p: priorities) {
            pq.offer(p);
        }
        
        int count = 0;
        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(pq.peek() == priorities[i]) {
                    count++;
                    pq.poll();
                }
                else if(pq.peek() != priorities[i]) continue;
                
                if(i == location) return count;
            }
        }
        int answer = -1;
        return answer;
    }
}