import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() &&
              (stack.peek() == '(' && s.charAt(i) == ')')) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()) return true;
        return false;

    }
}