import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static Map<Integer, Set<Integer>> tree;

    public static void removeNode(int node) {
        Set<Integer> currSet = tree.get(node);

        if (currSet.size() == 0) {
            tree.remove(node);
            return;
        }

        for (int curr : currSet) {
            if (tree.containsKey(curr)) {
                removeNode(curr);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int node = Integer.parseInt(br.readLine());

        tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(input[i]);

            Set<Integer> parentSet = tree.get(curr);
            Set<Integer> currSet = tree.get(i);

            if (currSet == null) {
                currSet = new HashSet<>();
                tree.put(i, currSet);
            }

            if (curr != -1) {
                if (parentSet == null) {
                    parentSet = new HashSet<>();
                }
                parentSet.add(i);
                tree.put(curr, parentSet);
            }
        }

        removeNode(node);

        int count = 0;
        for (int key : tree.keySet()) {
            Set<Integer> currSet = tree.get(key);
            if (currSet.contains(node)) {
                currSet.remove(node);
            }
            if (currSet.size() == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}