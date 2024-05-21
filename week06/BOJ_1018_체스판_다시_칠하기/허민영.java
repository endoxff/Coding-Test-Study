import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static boolean[][] map;
    static int min = 64;


    public static void main(String[] args) throws IOException {

        //1018- 체스판 다시 칠하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        n = Integer.parseInt(NM[0]);
        m = Integer.parseInt(NM[1]);
        map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'B') {
                    map[i][j] = false;
                } else {
                    map[i][j] = true;
                }
            }
        }


        for (int i = 0; i < n - 7; i++) { //세로 10  3번  가야함(0,1,2)
            for (int j = 0; j < m - 7; j++) { //가로 13 5번 더 가야함
                find(i, j);
            }
        }
        System.out.println(min);
    }

    static void find(int x, int y) {
        int cnt = 0;
        int end_x = x + 8;
        int end_y = y + 8;
        boolean start = map[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (map[i][j] != start) {
                    cnt++;
                }
                start = !start; //boolean값을 계속 바꿔줌 계속 달라야하니까
            }
            start = !start;
        }

        cnt = Math.min(cnt, 64 - cnt);

        min = Math.min(min, cnt);
    }

}

