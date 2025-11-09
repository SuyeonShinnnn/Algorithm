import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int nge[] = new int[n];
        Arrays.fill(nge, -1);

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < arr[i]) {
                int[] peek = stack.pop();
                nge[peek[1]] = arr[i];
            }
            stack.add(new int[]{arr[i], i});

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(nge[i] + " ");
        }
        System.out.println(sb);
    }
}