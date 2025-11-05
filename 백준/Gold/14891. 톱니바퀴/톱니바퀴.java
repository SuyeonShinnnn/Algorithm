import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void moveWheel(int[][] wheel, int[][] tip, int idx, int dir) {
        tip[idx][0] = (tip[idx][0] - dir) % 8;
        if (tip[idx][0] == -1) tip[idx][0] = 7;
        tip[idx][1] = (tip[idx][0] + 4) % 8;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] wheel = new int[4][8];
        int[][] tip = new int[4][2];
        for (int i = 0; i < 4; i++) {
            String state = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Character.getNumericValue(state.charAt(j));
            }
            tip[i][0] = 2; // 오른쪽
            tip[i][1] = 6; // 왼쪽
        }

        int n = Integer.parseInt(br.readLine());
        int[][] move = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            move[i][0] = Integer.parseInt(input[0]);
            move[i][1] = Integer.parseInt(input[1]);
        }

        for (int[] m : move) {
            int wheelNumber = m[0] - 1;
            int direction = m[1];

            int nextDirection = direction;
            int[][] nextTip = new int[4][4];
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 2; j++) {
                    nextTip[i][j] = tip[i][j];
                }
            }

            // 왼쪽 톱니바퀴들
            for (int i = wheelNumber - 1; i >= 0; i--) {
                nextDirection *= -1;
                if (wheel[i][tip[i][0]] != wheel[i + 1][tip[i + 1][1]]) {
                    moveWheel(wheel, nextTip, i, nextDirection);
                    continue;
                }
                break;
            }

            // 오른쪽 톱니바퀴들
            nextDirection = direction;
            for (int i = wheelNumber + 1; i < 4; i++) {
                nextDirection *= -1;
                if (wheel[i - 1][tip[i - 1][0]] != wheel[i][tip[i][1]]) {
                    moveWheel(wheel, nextTip, i, nextDirection);
                    continue;
                }
                break;
            }
            moveWheel(wheel, nextTip, wheelNumber, direction);
            tip = nextTip.clone();
        }
        int score = 0;

        for(int i = 0; i < 4; i++) {
            score += wheel[i][(tip[i][1] + 2) % 8] * Math.pow(2, i);
        }
        System.out.println(score);
    }
}