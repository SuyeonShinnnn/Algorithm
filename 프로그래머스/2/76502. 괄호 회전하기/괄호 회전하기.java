import java.util.*;

class Solution {
    
    public boolean spinning(String s, int start) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = start; i < s.length() + start; i++) {
            char curr = s.charAt(i % s.length());
       
            if(!stack.isEmpty() && ((stack.peek() == '(' && curr == ')') 
              || (stack.peek() == '[' && curr == ']')
              || (stack.peek() == '{' && curr == '}'))) {
                stack.pop();
            }
            else {
                stack.push(curr);
            }
        }
   
        if(!stack.isEmpty()) return false;
        return true;
    }
    public int solution(String s) {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(spinning(s, i)) {
                count++;
            }
        }
        return count;
    }
}