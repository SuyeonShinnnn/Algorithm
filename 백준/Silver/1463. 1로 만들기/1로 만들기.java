import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == 1) {
                System.out.println(curr[1]);
                break;
            }

            if(curr[0] % 3 == 0) {
                q.offer(new int[]{curr[0] / 3, curr[1] + 1});
            }
            if(curr[0] % 2 == 0) {
                q.offer(new int[]{curr[0] / 2, curr[1] + 1});
            }
            q.offer(new int[]{curr[0] - 1, curr[1] + 1});

        }
    }
}