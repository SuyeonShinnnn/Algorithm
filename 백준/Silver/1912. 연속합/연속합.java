import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] nums;

    public static int dp(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                list.add(nums[0]);
            } else {
                list.add(Math.max(list.get(list.size() - 1) + nums[i], nums[i]));
            }
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int answer = dp(n);
        System.out.println(answer);

    }
}