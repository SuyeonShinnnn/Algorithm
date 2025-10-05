/*
기록 O -> 더 많이 받은 사람이 다음달에 하나 받기
기록 X || 수 같음 -> 선물지수 큰 사람이 작은 사람에게서 하나 받음(선물지수도 같으면 주고받지 않음)
선물 지수 = 준 선물 수 - 받은 선물 수

friends -> 친구들 이름
gifts -> 선물 기록 [주는 친구, 받는 친구]
다음달에 가장 많은 선물을 받는 친구가 받을 선물 수 return
*/

import java.util.*;

class Solution {
    private Map<String, Map<String, Integer>> map = new HashMap<>();
    private Map<String, Integer> result = new HashMap<>();
    
    public int getGiftScore(String a) {
        int score = 0;
        for(String s : map.get(a).keySet()) {
            score += map.get(a).get(s);
            score -= map.get(s).get(a);
        }
        return score;
    }
    public String compareGiftScore(String a, String b) {
        int aScore = getGiftScore(a);
        int bScore = getGiftScore(b);
        
        if(aScore > bScore) {
            return a;
        }
        else if(aScore < bScore) {
            return b;
        }
        return "-";
    }
    
    public int solution(String[] friends, String[] gifts) {
        for(int i = 0; i < friends.length; i++) {
            map.put(friends[i], new HashMap<>());
            result.put(friends[i], 0);
            for(int j = 0; j < friends.length; j++) {
                if(friends[i].equals(friends[j])) continue;
                map.get(friends[i]).put(friends[j], 0);
            }
        }
        
        for(int i = 0; i < gifts.length; i++) {
            String[] f = gifts[i].split(" ");
            
            int count = map.get(f[0]).get(f[1]);
            map.get(f[0]).put(f[1], count + 1);
        }
        
        
        for(String s : map.keySet()) {
            for(String s2: map.get(s).keySet()) {
                int cnt1 = map.get(s).get(s2);
                int cnt2 = map.get(s2).get(s);
                
                if(cnt1 > cnt2) {
                    int cnt = result.get(s);
                    result.put(s, cnt + 1);
                }
                else if(cnt1 < cnt2) {
                    int cnt = result.get(s2);
                    result.put(s2, cnt + 1);
                }
                else if(cnt1 == cnt2) {
                    String r = compareGiftScore(s, s2);
                    if(r.equals(s)) {
                        int cnt = result.get(s);
                        result.put(s, cnt + 1);
                    }
                    else if (r.equals(s2)) {
                        int cnt = result.get(s2);
                        result.put(s2, cnt + 1);
                    }
                    else if(r.equals("-"))
                        continue;
                }
            }
        }
        
        int max = 0;
        for(String s : result.keySet()) {
            if(max < result.get(s) / 2)
                max = result.get(s) / 2;
        }
        
        return max;
    }
}