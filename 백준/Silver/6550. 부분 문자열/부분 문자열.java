import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line= br.readLine();
            if (line == null) break;
            if(line.equals("")) break;

            String[] input = line.split(" ");
            int t = 0;
            for (int i = 0; i < input[1].length(); i++) {
                if (input[0].charAt(t) == input[1].charAt(i)) {
                    t++;
                }
                if (t == input[0].length()) break;
            }
            if (t == input[0].length()) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}