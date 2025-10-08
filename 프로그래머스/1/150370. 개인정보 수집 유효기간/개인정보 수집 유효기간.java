import java.util.*;

class Solution {
    private Map<String, Integer> periodInfo = new HashMap<>();
    private List<Integer> result = new LinkedList<>();
    
    public int[] parseDate(String date) {
        int[] termYMD = new int[3];
        
        String[] d = date.split("\\.");
        termYMD[0] = Integer.parseInt(d[0]);
        termYMD[1] = Integer.parseInt(d[1]);
        termYMD[2] = Integer.parseInt(d[2]);
        
        return termYMD;
    }
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        int[] todayYMD = parseDate(today);
        
        for(String t : terms) {
            String[] curr = t.split(" ");
            periodInfo.put(curr[0], Integer.parseInt(curr[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] curr = privacies[i].split(" ");
            
            int period = periodInfo.get(curr[1]);
            int[] currYMD = parseDate(curr[0]);
            
            currYMD[1] += period;
            
            if(currYMD[1] > 12) {
                currYMD[0] += (currYMD[1] - 1) / 12;
                currYMD[1] = (currYMD[1] - 1) % 12 + 1;
            }
        
            System.out.println(currYMD[0] + " " + currYMD[1] + " " + currYMD[2]);
     
            if(currYMD[0] < todayYMD[0]) {
                result.add(i + 1);
            }
            else if((currYMD[0] == todayYMD[0]) && (currYMD[1] < todayYMD[1])) {
                result.add(i + 1);
            }
            else if((currYMD[0] == todayYMD[0]) && (currYMD[1] == todayYMD[1]) && (currYMD[2] <= todayYMD[2])) {
                result.add(i + 1);
            }
        }
        
               
        return result;
    }
}