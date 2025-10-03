import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(stack.size() == 0) {
                stack.push(curr);
            }
            else if(stack.peek() == '(' && curr == ')') {
                stack.pop();
            }
            else {
                stack.push(curr);
            }
        }
        
        if(stack.size() == 0)
            answer = true;
        
        return answer;
    }
}