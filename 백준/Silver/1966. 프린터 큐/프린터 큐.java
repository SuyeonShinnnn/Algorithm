import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");

            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (a, b) -> b - a
            );

            for (int j = 0; j < n; j++) {
                int curr = Integer.parseInt(input[j]);
                q.offer(new int[]{j, curr});
                pq.offer(curr);
            }

            int count = 1;
            while (!pq.isEmpty()) {
                int[] curr = q.poll();

                if (curr[1] < pq.peek()) {
                    q.offer(curr);
                    continue;
                }
                pq.poll();

                if (curr[0] == m) {
                    System.out.println(count);
                    break;
                }
                count++;
            }
        }
    }
}