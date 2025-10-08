class Solution {
    private int count = 0;
    public void backtracking(int[] arr, int[] number, boolean[] visited
                             , int start, int depth) {
        if(depth == 3) {
            int sum = 0;
            for(int a: arr) {
                sum += a;
            }
            if(sum == 0) {
                count++;
            }
            System.out.println();
            return;
        }
        for(int i = start; i < number.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = number[i];
                backtracking(arr, number, visited, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
    public int solution(int[] number) {
        backtracking(new int[3], number, new boolean[number.length], 0, 0);
     
        return count;
    }
}