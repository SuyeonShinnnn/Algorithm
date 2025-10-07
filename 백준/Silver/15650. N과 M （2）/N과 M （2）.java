
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class Main {
        public static void backtracking(int[] arr, int n, int m, int depth, int start, boolean[] visited) {
            if(m == depth) {
                for(int i = 0; i < m; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                return;
            }

            for(int i = start; i < n; i++) {
                if(!visited[i]) {
                    visited[i] = true;

                    arr[depth] = i + 1;

                    backtracking(arr, n, m, depth + 1, i + 1, visited);
                    visited[i] = false;
                }
            }
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] ans = br.readLine().split(" ");
            int n = Integer.parseInt(ans[0]);
            int m = Integer.parseInt(ans[1]);

            backtracking(new int[m], n, m, 0, 0, new boolean[n]);
        }
    }