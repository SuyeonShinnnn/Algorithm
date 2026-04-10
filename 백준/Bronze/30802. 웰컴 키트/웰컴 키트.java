import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //참가자 수
        int n = Integer.parseInt(br.readLine());

        // 사이즈 별 필요한 티셔츠 개수
        String[] input = br.readLine().split(" ");
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 티 묶음, 펜 묶음
        input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        int count = 0;
        for (int i = 0; i < 6; i++) {
            count += (int) Math.ceil((double) arr[i] / t);
        }
        System.out.println(count);
        System.out.println(n / p + " " + n % p);
    }
}