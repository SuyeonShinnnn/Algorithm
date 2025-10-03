import java.util.*;

public class Solution { 
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(answer.size() != 0) {
                int last = answer.get(answer.size() - 1);
                if(last != arr[i]) {
                    answer.add(arr[i]);
                }
            }
            if(answer.size() == 0) {
                answer.add(arr[i]);
            }
        }

        return answer;
    }
}