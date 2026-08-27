import java.util.*;

class Solution {
    public boolean search(int idx, String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt((i + idx) % s.length());
            
            if(!stack.isEmpty() 
                    && ((stack.peek() == '[' && curr == ']')
                   || (stack.peek() == '{' && curr == '}')
                   || (stack.peek() == '(' && curr == ')'))) {
                stack.pop();
            }
            else {
                stack.add(curr);
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(search(i, s)) {
                answer++;
            }
        }
        return answer;
    }
}