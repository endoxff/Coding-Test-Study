import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static boolean[][] visited;
    static char[][] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ch = new char[n][n];

        for (int i = 0; i < n; i++) {
            ch[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][n];

        int answer1 = 0;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y]) {
                    dfs(x, y, ch[x][y]);
                    answer1++;
                }
                if (ch[x][y] == 'G') {
                    ch[x][y] = 'R';
                }
            }
        }

        visited = new boolean[n][n];
        int answer2 = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y]) {
                    dfs(x, y, ch[x][y]);
                    answer2++;
                }
            }
        }
        System.out.print(answer1 + " " + answer2);
    }

    public static void dfs(int x, int y, char target) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int curx = x + dx[i], cury = y + dy[i];
            if (curx >= 0 && curx < n && cury >= 0 && cury < n && ch[curx][cury] == target) {
                dfs(curx, cury, target);
            }
        }
    }
}