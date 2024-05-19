import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static void swap(char[][] b, int i, int j, int x, int y) {
        char temp = b[i][j];
        b[i][j] = b[x][y];
        b[x][y] = temp; 
    }

    static int solution(char[][] b, int n){
        int count = 0;
        int max = Integer.MIN_VALUE;

        //열
        for(int i = 0; i < n; i++) {
            char word = b[i][0];
            count = 0;
            for(int j = 0; j < n; j++) {
                if(word != b[i][j]) {
                    max = max < count ? count : max;
                    count = 0;
                    word = b[i][j];
                }
                count++;
            }
            max = max < count ? count : max;
        }

        //행
        for(int i = 0; i < n; i++) {
            char word = b[0][i];
            count = 0;
            for(int j = 0; j < n; j++) {
                if(word != b[j][i]) {
                    max = max < count ? count : max;
                    count = 0;
                    word = b[j][i];
                }
                count++;
            }
            max = max < count ? count : max;
        }
        return max;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int max = solution(board, n);
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j != n - 1 && board[i][j] != board[i][j + 1]) {
                    swap(board, i, j, i, j + 1);
                    count = solution(board, n);
                    swap(board, i, j, i, j + 1);
                }

                max = max < count ? count : max;
                    
                if(i != n - 1 && board[i][j] != board[i + 1][j]) {
                    swap(board, i, j, i + 1, j);
                    count = solution(board, n);
                    swap(board, i, j, i + 1, j);
                }
                max = max < count ? count : max;
            }
        }
        System.out.println(max);
    }
}
