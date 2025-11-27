import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int m;
    static List<Integer> list;

    public static void dfs(int[] arr, boolean[] visited, int depth, Set<String> set) {
        if (depth == m) {
            String curr = Arrays.toString(arr);
            if (!set.contains(curr)) {
                for (int a : arr) {
                    System.out.print(a + " ");
                }
                System.out.println();
                set.add(curr);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = list.get(i);
                dfs(arr, visited, depth + 1, set);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        list = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(list);

        dfs(new int[m], new boolean[n], 0, new HashSet<>());
    }
}