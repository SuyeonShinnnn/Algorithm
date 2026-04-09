import java.io.*;
import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        while (n > 0) {
            n--;
            String[] order = br.readLine().split(" ");
            if (order[0].equals("all")) {
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
                continue;
            } else if (order[0].equals("empty")) {
                set.clear();
                continue;
            }

            int num = Integer.parseInt(order[1]);

            if (order[0].equals("add")) {
                set.add(num);
            } else if (order[0].equals("remove") && set.contains(num)) {
                set.remove(num);
            } else if (order[0].equals("check")) {
                if (set.contains(num)) {
                    sb.append("1\n");
                    continue;
                }
                sb.append("0\n");
            } else if (order[0].equals("toggle")) {
                if (set.contains(num)) {
                    set.remove(num);
                    continue;
                }
                set.add(num);
            }
        }
        System.out.println(sb);
    }
}