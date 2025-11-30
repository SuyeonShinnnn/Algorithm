import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int search(int target, int[] arr, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) return 1;
            else if (arr[mid] < target) start = mid + 1;
            else if (arr[mid] > target) end = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            t--;
            int n = Integer.parseInt(br.readLine());

            int[] arr1 = new int[n];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(input[i]);
            }

            int m = Integer.parseInt(br.readLine());
            int[] arr2 = new int[m];
            input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(arr1);
            
            StringBuilder sb = new StringBuilder();
            for (int a2 : arr2) {
                int result = search(a2, arr1, 0, n - 1);
                sb.append(result + "\n");
            }
            System.out.print(sb);
        }
    }
}