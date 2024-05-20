import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {

        //N * N 크기의 보드 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int max = 1;
        //오른쪽 칸과 교환 후, 가장 긴 연속 부분의 길이 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                max = Math.max(getLongestLength(), max);
                swap(i, j + 1, i, j);
            }
        }

        //아랫쪽 칸과 교환 후, 가장 긴 연속 부분의 길이 찾기
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                swap(i, j, i + 1, j);
                max = Math.max(getLongestLength(), max);
                swap(i + 1, j, i, j);
            }
        }

        System.out.println(max);
    }

    /*
    가장 긴 연속 부분의 길이를 찾는 함수
     */
    private static int getLongestLength() {
        int max = 0;
        //행에서 가장 긴 연속 부분의 길이 찾기
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        //열에서 가장 긴 연속 부분의 길이 찾기
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 0; i < N - 1; i++) {
                if (board[i][j] == board[i + 1][j]) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        return max;
    }

    /*
    board[x1][y1]을 board[x2][y2]로 교환하는 함수
     */
    private static void swap(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }
}