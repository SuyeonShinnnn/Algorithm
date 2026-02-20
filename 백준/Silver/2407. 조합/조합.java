import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        BigInteger sum = new BigInteger("1");
        for (int i = n; i > n - m; i--) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        for (int i = m; i > 0; i--) {
            sum = sum.divide(BigInteger.valueOf(i));
        }
        System.out.println(sum);
    }
}