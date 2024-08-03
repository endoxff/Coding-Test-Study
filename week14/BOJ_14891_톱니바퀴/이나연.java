import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] A;
    static final int LEFT = 6;
    static final int RIGHT = 2;

    public static void main(String[] args) throws IOException {

        //톱니바퀴의 상태 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new int[5][8];
        for (int i = 1; i <= 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        //회전 횟수 N, 회전시킨 방법 입력
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //톱니바퀴 회전
            int gear = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            left(gear, direction);
            right(gear, direction);
            move(gear, direction);
        }

        //톱니바퀴의 점수의 합 출력
        int score = 0;
        for (int i = 1; i <= 4; i++) {
            if (A[i][0] == 1) {
                score += Math.pow(2, i - 1);
            }
        }
        System.out.println(score);
    }

    //왼쪽 톱니바퀴 회전
    private static void left(int gear, int direction) {
        if (gear == 1) {
            return;
        }

        if (A[gear][LEFT] != A[gear - 1][RIGHT]) {
            left(gear - 1, direction * -1);
            move(gear - 1, direction * -1);
        }
    }

    //오른쪽 톱니바퀴 회전
    private static void right(int gear, int direction) {
        if (gear == 4) {
            return;
        }

        if (A[gear][RIGHT] != A[gear + 1][LEFT]) {
            right(gear + 1, direction * -1);
            move(gear + 1, direction * - 1);
        }
    }

    //톱니바퀴 회전
    private static void move(int gear, int direction) {
        if (direction == 1) {
            int tmp = A[gear][7];
            for (int i = 7; i > 0; i--) {
                A[gear][i] = A[gear][i - 1];
            }
            A[gear][0] = tmp;
        } else { //direction == -1
            int tmp = A[gear][0];
            for (int i = 0; i < 7; i++) {
                A[gear][i] = A[gear][i + 1];
            }
            A[gear][7] = tmp;
        }
    }
}