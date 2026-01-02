import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static char[] input;
    public static boolean[] visited;

    public static void dfs(char[] arr, int depth, Set<String> set) {
        String curr = new String(arr);
        
        if (depth == input.length) {
            System.out.println(arr);
            set.add(curr);
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (!visited[i] && !set.contains(curr)) {
                visited[i] = true;
                arr[depth] = input[i];
                dfs(arr, depth + 1, set);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            input = br.readLine().toCharArray();
            Arrays.sort(input);
            visited = new boolean[input.length];

            dfs(new char[input.length], 0, new HashSet<>());
        }
    }
}