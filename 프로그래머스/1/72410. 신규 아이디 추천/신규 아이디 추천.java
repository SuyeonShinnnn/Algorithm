import java.util.*;
import java.util.regex.*;

class Solution {
    private Deque<Character> deque = new ArrayDeque<>();
    
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        
        for(int i = 0; i < new_id.length(); i++) {
            char currChar = new_id.charAt(i);
            int asci = (int)currChar;
            
            // 현재 문자가 .이고 덱이 비어있지 않거나 peekLast가 .이 아닐 때 해당 문자 offerLast
            if(currChar == '.') {
                if(!deque.isEmpty() && deque.peekLast() != '.') {
                    deque.offerLast(currChar);
                }
            }
            // a-z, 0-9, -, _ 문자는 무조건 덱에 넣기
            else if((asci >= 97 && asci <= 122) || (asci >= 48 && asci <= 57) || currChar == '-' || currChar == '_') {
                deque.offerLast(currChar);
            }
        }
        
        // 덱이 비어있으면 a offerLast
        if(deque.isEmpty()) {
            deque.offerLast('a');
        }
        // 덱 사이즈가 16이상일 때 사이즈가 15가 될때까지 pollLast
        if(deque.size() >= 16) {
            while(deque.size() != 15) deque.pollLast();
        }
        // 덱 last가 .일 때 pollLast
        if(deque.peekLast() == '.') deque.pollLast();
        
        // 덱 사이즈가 2이하일 때 3이될 때까지 last 문자 push
        if(deque.size() <= 2) {
            while(deque.size() != 3) {
                deque.offerLast(deque.peekLast());
            }
        }
        
        String answer = "";
        while(!deque.isEmpty()) {
            answer += deque.pollFirst();
        }
        
        return answer;
    }
}