import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int l;
    static int c;
    static char[] alphabets;
    static final Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');

    public static boolean isProperPW(Set<Character> visited) {
        HashSet<Character> consonant = new HashSet<>(visited);
        consonant.removeAll(vowel);

        if (consonant.size() >= 2 && visited.size() - consonant.size() != 0) return true;
        return false;
    }

    public static void dfs(char[] password, Set<Character> visited, int depth, int start) {
        if (depth == l) {
            if (isProperPW(visited)) {
                for (char pw : password) {
                    System.out.print(pw);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < c; i++) {
            if (!visited.contains(alphabets[i])) {
                visited.add(alphabets[i]);
                password[depth] = alphabets[i];

                dfs(password, visited, depth + 1, i + 1);

                visited.remove(alphabets[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        alphabets = Arrays.stream(br.readLine().split(" "))
                .map(s -> s.charAt(0))
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString()
                .toCharArray();

        Arrays.sort(alphabets);

        dfs(new char[l], new HashSet<>(), 0, 0);
    }
}