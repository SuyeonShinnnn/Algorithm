class Solution {
    private int[] videoLen = new int[2];
    private int[] curr = new int[2];
    private int[] start = new int[2];
    private int[] end = new int[2];
    
    public void init(String video, String pos, String opStart, String opEnd) {
        String[] v = video.split(":");
        videoLen[0] = Integer.parseInt(v[0]); videoLen[1] = Integer.parseInt(v[1]);
        
        v = pos.split(":");
        curr[0] = Integer.parseInt(v[0]); curr[1] = Integer.parseInt(v[1]);
        
        v = opStart.split(":");
        start[0] = Integer.parseInt(v[0]); start[1] = Integer.parseInt(v[1]);
        
        v = opEnd.split(":");
        end[0] = Integer.parseInt(v[0]); end[1] = Integer.parseInt(v[1]);
    }
    public void moveToPrev() {
        if(curr[0] == 0 && curr[1] <= 10) {
            curr[0] = 0; curr[1] = 0;
        }
        else if(curr[0] == 0 && curr[1] > 10) {
            curr[1] -= 10;
        }
        else if(curr[0] > 0 && curr[1] < 10) {
            curr[0] -= 1;
            curr[1] = curr[1] + 60 - 10;
        }
        else if(curr[0] > 0 && curr[1] >= 10) {
            curr[1] = curr[1] - 10;
        }
    }
    
    public void moveToNext() {
        curr[1] += 10;
        curr[0] += curr[1] / 60;
        curr[1] %= 60;
        
        if((curr[0] > videoLen[0]) || (curr[0] == videoLen[0] && curr[1] > videoLen[1])) {
            curr[0] = videoLen[0]; curr[1] = videoLen[1];
        }
       
    }
    
    public void checkOp() {
        boolean isNextStart = (curr[0] == start[0] && curr[1] >= start[1]) || (curr[0] > start[0]);
        boolean isPrevEnd = (curr[0] == end[0] && curr[1] < end[1]) || (curr[0] < end[0]);
        if(isNextStart && isPrevEnd) {
            curr[0] = end[0];
            curr[1] = end[1];
        }
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        init(video_len, pos, op_start, op_end);
        for(String comm : commands) {
            checkOp();
            if(comm.equals("prev")) {
                moveToPrev();
            }
            else if(comm.equals("next")) {
                moveToNext();
            }
        }
        checkOp();
        
        String answer = "";
        if(curr[0] < 10) {
            answer += ("0" + Integer.toString(curr[0])) + ":";
        }
        else answer += Integer.toString(curr[0]) + ":";
        
        if(curr[1] < 10) {
            answer += ("0" + Integer.toString(curr[1]));
        }
        else answer += Integer.toString(curr[1]);
        return answer;
    }
}