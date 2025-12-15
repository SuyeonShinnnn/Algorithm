import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int c;
    public static long pow(int a, long exponent) {
        if (exponent == 1) {
            return a % c;
        }

        long temp = pow(a, exponent / 2);

        if (exponent % 2 == 1) return (temp * temp % c) * a % c;

        return temp * temp % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        System.out.println(pow(a, b));
    }
}