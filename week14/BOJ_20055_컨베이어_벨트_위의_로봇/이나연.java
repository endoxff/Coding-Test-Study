import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] robot = new boolean[N * 2];

        int step = 1;
        while (true) {
            //컨베이어 벨트 회전
            int tmp = A[N * 2 - 1];
            for (int i = N * 2 - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = tmp;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false; //로봇이 내리기

            //로봇 이동
            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && A[i] > 0) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    A[i]--;
                }
            }

            //로봇 올리기
            if (A[0] > 0) {
                robot[0] = true;
                A[0]--;
            }

            //내구도가 0인 칸의 개수 세기
            int count = 0;
            for (int i = 0; i < N * 2; i++) {
                if (A[i] == 0) {
                    count++;
                }
            }
            if (count >= K) {
                break;
            }

            step++;
        }

        System.out.println(step);
    }

}