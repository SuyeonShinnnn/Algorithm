import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> inEdge = new HashMap<>();
        Map<Integer, Integer> outEdge = new HashMap<>();
        int[] answer = new int[4];
        
        for(int[] e: edges) {
            outEdge.put(e[0], outEdge.getOrDefault(e[0], 0) + 1);
            inEdge.put(e[1], inEdge.getOrDefault(e[1], 0) + 1);
        }
        
        for(int k: outEdge.keySet()) {
            // 나가는 간선이 1보다 크고 
            // 들어오는 간선이 없으면 추가 노드
            // 들어오는 간선이 있으면 8자
            if(outEdge.get(k) > 1) {
                if(!inEdge.containsKey(k)) {
                    answer[0] = k;
                }
                else{
                    answer[3] += 1;
                }
            }
        }
        
        // 들어오는 간선은 있는데
        // 나가는 간선이 없으면 
        // 막대 모양의 가장 끝 노드
        for(int k : inEdge.keySet()) {
            if(!outEdge.containsKey(k)) {
                answer[2] += 1;
            }
        }
        
        answer[1] = outEdge.get(answer[0]) - answer[2] - answer[3];
         
        return answer;
    }
}