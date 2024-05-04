import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static int n, m;

    static int[][] box;
    static Queue<tomato> queue = new LinkedList<tomato>();

    static int cnt;

    static boolean checkTomato() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0)
                    return false;
                // 덜 익은 토마토가 있다면
            }
        }
        return true;
    }

    public static void bfs() {
        int day = 0;
        while (!queue.isEmpty()) {
            tomato t = queue.poll();
            day = t.day;

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.add(new tomato(nx, ny, day + 1));
                    }
                }
            }

        }
        if (checkTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }


    static class tomato {
        int x;
        int y;
        int day;

        tomato(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.day = d;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] istomato = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(istomato[j]);
                if (box[i][j] == 1) {
                    queue.add(new tomato(i, j, 0));
                }
            }
        }

        bfs();

    }

}