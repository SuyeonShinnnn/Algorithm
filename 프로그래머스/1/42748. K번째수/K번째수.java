import java.util.*;

class Solution {
    public int[] splitArr(int[] array, int s, int e) {
        int[] arr = new int[e - s + 1];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = array[s + i];
        }
        Arrays.sort(arr);
        
        return arr;
    }
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new LinkedList<>();
        
        for(int i = 0; i < commands.length; i++) {
            int arr[] = splitArr(array, commands[i][0] - 1, commands[i][1] - 1);
            answer.add(arr[commands[i][2] - 1]);
        }
        
        return answer;
    }
}