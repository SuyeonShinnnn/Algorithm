import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        int[] tops = new int[n];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && tops[i] > tops[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer[i] = stack.peek() + 1;
            }
            stack.add(i);
        }
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}