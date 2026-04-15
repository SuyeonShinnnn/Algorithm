import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void dslr(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];

        q.offer(a);
        visited[a] = true;
        Arrays.fill(command, "");

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == b) {
                sb.append(command[b] + "\n");
                return;
            }

            int next = (curr * 2) % 10000;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(next);
                command[next] = command[curr] + "D";
            }

            if (curr == 0) next = 9999;
            else next = curr - 1;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(next);
                command[next] = command[curr] + "S";
            }

            next = (curr % 1000) * 10 + curr / 1000;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(next);
                command[next] = command[curr] + "L";
            }

            next = (curr % 10) * 1000 + curr / 10;
            if (!visited[next]) {
                visited[next] = true;
                q.offer(next);
                command[next] = command[curr] + "R";
            }
        }
    }

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            dslr(a, b);
        }

        System.out.println(sb);
    }
}