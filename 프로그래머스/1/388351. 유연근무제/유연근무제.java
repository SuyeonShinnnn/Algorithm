/*
출근 희망 시각 + 10분까지 어플 출근!!
주말 출근 시각은 이벤트에 영향 X
n: 직원 수
schedules: 출근 희망 시각
timelogs: 일주일 동안 출근한 시각
startday: 이벤트 시작 요일
상품 받을 직원 수 return
*/

import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int m = (schedules[i] + 10) % 100;
            int h = (schedules[i] / 100) + (m / 60);
            m = m % 60;
    
            int count = 0;
            for(int j = 0; j < timelogs[i].length; j++) {
                int tH = timelogs[i][j] / 100;
                int tM = timelogs[i][j] % 100;
                
                
                if((j + startday) % 7 == 6 || (j + startday) % 7 == 0){
                    continue;
                }
                if((tM >= m && tH < h) || (tM < m && tH <= h) ||
                   (tM == m && tH == h)){
                    continue;
                }
                count++;
            }
            if(count == 0) {
                answer++;
            }
        }
        return answer;
    }
}
