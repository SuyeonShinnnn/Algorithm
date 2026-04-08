import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);

            String result = "";
            int floor = n % h;
            if (floor == 0) result += Integer.toString(h);
            else result += Integer.toString(floor);

            int roomNum = (int) Math.ceil((double) n / h);

            if (roomNum < 10) result += ("0" + Integer.toString(roomNum));
            else result += Integer.toString(roomNum);

            System.out.println(result);
        }
    }
}