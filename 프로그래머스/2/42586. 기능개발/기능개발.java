import java.util.*; 

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> counts = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
		    //✅ 작업의 남은 일수를 계산하여 큐에 삽입한다.
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        //✅ 큐가 빌때까지 반복한다.
        while (!queue.isEmpty()) {
	        	//✅ 큐에서 요소 하나를 뽑는다.
            int current = queue.remove();
          	//✅ 배포 작업 개수를 1으로 초기화한다.
            int count = 1;
            
          	//✅ 큐의 맨 위 요소가 자신보다 작은 동안 요소를 제거하고 작업 개수를 1 늘린다.
            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.remove();
                count++;
            }
          	//✅ 작업 개수를 리스트에 저장한다.
            counts.add(count);
        }
        
        //✅ 작업 개수를 반환한다.
        int[] answer = new int[counts.size()];
        for (int i = 0; i < counts.size(); i++) {
            answer[i] = counts.get(i);
        }
        return answer;
    }
}