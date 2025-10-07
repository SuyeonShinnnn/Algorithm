import java.util.*;
import java.util.stream.*;

class Solution {
    private List<int[]> list = new ArrayList<>();
    private int[][] q;
    private int n;
    private int[] ans;
    private int count;
    
    public void init(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        this.count = 0;
    }
    
    public boolean compare(int[] arr) {
        Set<Integer> s = Arrays.stream(arr).boxed().collect(Collectors.toSet());
      
        for(int i = 0; i < q.length; i++) {
            Set<Integer> s1 = new HashSet<>(s);
            Set<Integer> s2 = Arrays.stream(q[i]).boxed().collect(Collectors.toSet());

            s1.retainAll(s2);
            
            if(s1.size() == this.ans[i]) {
                continue;
            }
            return false;
        }
        return true;
    }
    
    public void backtracking(int[] arr, boolean[] visited, int s, int depth) {
        if(depth == 5) {
            if(compare(arr)){
                count += 1;
            }
            
            list.add(arr.clone());
            
            return;
        }
        
        for(int i = s; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                backtracking(arr, visited, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
  
    public int solution(int n, int[][] q, int[] ans) {
        init(n, q, ans);
        backtracking(new int[5], new boolean[n], 0, 0);
    
        System.out.println(count);
        int answer = 0;
        return count;
    }
}
    