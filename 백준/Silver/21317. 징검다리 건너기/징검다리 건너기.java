import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int k;
    static int[][] energy;

    public static int dp() {
        int[][] arr = new int[n + 1][2];

        for (int i = 2; i <= n; i++) {
            arr[i][0] = Integer.MAX_VALUE;
            arr[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            if (i == 2) {
                arr[2][0] = energy[1][0];
            } else if (i > 2) {
                arr[i][0] = Math.min(arr[i - 1][0] + energy[i - 1][0], arr[i - 2][0] + energy[i - 2][1]);
            }
            if (i + 3 <= n) {
                arr[i + 3][1] = Math.min(arr[i + 3][1], arr[i][0] + k);
            }
            if (i > 4) {
                arr[i][1] = Math.min(arr[i][1], arr[i - 1][1] + energy[i - 1][0]);
            }
            if (i > 5) {
                arr[i][1] = Math.min(arr[i][1], arr[i - 2][1] + energy[i - 2][1]);
            }
        }
        return Math.min(arr[n][0], arr[n][1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        energy = new int[n + 1][2];

        for (int i = 1; i < n; i++) {
            String[] input = br.readLine().split(" ");
            energy[i][0] = Integer.parseInt(input[0]);
            energy[i][1] = Integer.parseInt(input[1]);
        }
        k = Integer.parseInt(br.readLine());
        int answer = dp();
        System.out.println(answer);
    }
}