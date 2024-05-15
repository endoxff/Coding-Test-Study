import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] board; //입력 받을 보드
    static char[][] whiteChess; //흰색이 먼저 칠해져 있는 체스판
    static char[][] blackChess; //검은색이 먼저 칠해져 있는 체스판

    public static void main(String[] args) throws IOException {

        //M * N 크기의 보드 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        //8*8 체스판 채우기
        fillChessBoard();

        //다시 칠해야 하는 정사각형 개수의 최솟값 구하기
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, countPaint(i, j));
            }
        }

        System.out.println(min);
    }

    private static void fillChessBoard() {
        whiteChess = new char[8][8]; //흰색이 먼저 칠해져 있는 체스판
        blackChess = new char[8][8]; //검은색이 먼저 칠해져 있는 체스판
        char color = 'W';
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    whiteChess[i][j] = color;
                    color = (color == 'W') ? 'B' : 'W';
                    blackChess[i][j] = color;
                } else {
                    whiteChess[i][j] = color;
                    color = (color == 'B') ? 'W' : 'B';
                    blackChess[i][j] = color;
                }
            }

            color = (i % 2 == 0) ? 'B' : 'W';
        }
    }

    /**
     * 다시 칠해야 하는 정사각형 개수를 구하는 함수
     * 사용자가 입력한 보드와 체스판을 비교
     */
    private static int countPaint(int startRow, int startCol) {
        int whiteCount = 0;
        int blackCount = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //흰색이 먼저 칠해져 있는 체스판과 사용자가 입력한 보드 비교
                if (board[startRow + i][startCol + j] != whiteChess[i][j]) {
                    whiteCount++;
                }

                //검은색이 먼저 칠해져 있는 체스판과 사용자가 입력한 보드 비교
                if (board[startRow + i][startCol + j] != blackChess[i][j]) {
                    blackCount++;
                }
            }
        }

        return Math.min(whiteCount, blackCount);
    }

}