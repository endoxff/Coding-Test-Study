import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int count = checkBoard(i, j);
                result = count < result ? count : result;
            }
        }

        System.out.println(result);

    }

    static int checkBoard(int r, int c) {
        int min = Integer.MAX_VALUE;

        for (int k = 0; k < 2; k++) {
            char color = k == 0 ? 'W' : 'B';
            int count = 0;

            for (int i = r; i < r + 8; i++) {
                for (int j = c; j < c + 8; j++) {
                    if (board[i][j] != color) {
                        count++;
                    }

                    color = color == 'W' ? 'B' : 'W';
                }

                color = color == 'W' ? 'B' : 'W';
            }

            min = count < min ? count : min;
        }

        return min;
    }
}