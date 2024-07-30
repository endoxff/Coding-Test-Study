import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        //방의 크기 N과 M 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //로봇 청소기가 있는 칸의 좌표 (r,c)와 청소기가 바라보는 방향 d 입력
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        //각 장소의 상태 입력
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로봇 청소기가 청소하는 칸의 개수 구하기
        int count = 0;
        while (true) {
            //현재 칸이 아직 청소되지 않은 경우, 현재 칸 청소
            if (A[r][c] == 0) {
                count++;
                A[r][c] = 2;
            }

            //현재 칸의 주변 4칸 확인
            boolean cleaning = false;
            for (int i = 0; i < 4; i++) {
                //반시계 방향으로 90도 회전
                if (d == 0) {
                    d = 3;
                } else {
                    d--;
                }

                //청소된 칸인지 확인
                int x = r + dx[d];
                int y = c + dy[d];
                if (x >= 0 && x < N && y >= 0 && y < M && A[x][y] == 0) {
                    cleaning = true;
                    count++;
                    A[x][y] = 2; //청소된 칸으로 표시
                    r += dx[d];
                    c += dy[d];
                    break;
                }
            }

            //주변 4칸 중 청소되지 않은 빈 칸이 없는 경우, 한 칸 후진
            if (!cleaning) {
                int x = r - dx[d];
                int y = c - dy[d];
                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (A[x][y] == 1) { //뒤쪽 칸이 벽이라면, 작동을 멈춤
                        System.out.println(count);
                        System.exit(0);
                    } else {
                        r -= dx[d];
                        c -= dy[d];
                    }
                } else { //뒤쪽 칸이 벽이라면, 작동을 멈춤
                    System.out.println(count);
                    System.exit(0);
                }
            }
        }
    }

}