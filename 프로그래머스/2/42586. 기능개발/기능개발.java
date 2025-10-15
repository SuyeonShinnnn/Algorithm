import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            day[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        }
        
        int max = day[0];
        int count = 0;
        List<Integer> answer = new ArrayList<>();
        for(int d : day) {
            if(max < d) {
                max = d;
                answer.add(count);
                count = 0;
            }
            count++;
        }
        answer.add(count);

        return answer;
    }
}