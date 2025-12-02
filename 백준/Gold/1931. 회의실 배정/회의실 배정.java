import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            times.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }
        Collections.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prevEndTime = 0;
        for (int[] t : times) {
            if (prevEndTime <= t[0]) {
                count++;
                prevEndTime = t[1];
            }
        }
        System.out.println(count);
    }
}