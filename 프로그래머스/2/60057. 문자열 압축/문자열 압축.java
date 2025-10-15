import java.util.*;

class Solution {
    private int min = Integer.MAX_VALUE;
    private Stack<String> stack = new Stack<>();
    
    public void compString(String s, int n) {
        String result = "";
        
        for(int i = 0; i < s.length(); i += n) {
            String curr = s.substring(i);
            if(i + n < s.length()) {
                curr = s.substring(i, i + n);
            }
            if(stack.isEmpty() || stack.peek().equals(curr)) {
                stack.add(curr);
            }
            if(!stack.peek().equals(curr)) {
                if(stack.size() <= 1) {
                    result += stack.pop();
                }
                else {
                    result += (Integer.toString(stack.size()) + stack.pop());
                }
                stack.clear();
                stack.add(curr);
            }
        }
        int size = result.length() + stack.peek().length();
        
        if(stack.size() > 1) {
            int count = Integer.toString(stack.size()).length();
            size = result.length() + count + stack.peek().length();
        }
  
        if(min > size) min = size;
    } 
    
    public int solution(String s) {
        if(s.length() == 1) return 1;
        
        for(int i = 1; i <= s.length() / 2; i++) {
            compString(s, i);
            stack.clear();
        }
        
        return min;
    }
}