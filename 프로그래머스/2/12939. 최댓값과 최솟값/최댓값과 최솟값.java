class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String c: s.split(" ")) {
            int num = Integer.parseInt(c);
            
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        String answer = min + " " + max;
        return answer;
    }
}