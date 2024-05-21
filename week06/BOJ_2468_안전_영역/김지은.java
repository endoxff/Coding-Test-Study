import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        int max = 0;
        int min = 101;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = map[i][j] > max ? map[i][j] : max;
                min = map[i][j] < min ? map[i][j] : min;
            }
        }

        int safeZone = 0;

        for (int i = min - 1; i < max; i++) {
            int count = 0;
            visited = new boolean[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((map[j][k] > i) && (!visited[j][k])) {
                        bfs(j, k, i);
                        count++;
                    }
                }
            }

            safeZone = Math.max(safeZone, count);
        }

        System.out.println(safeZone);

    }

    public static void bfs(int r, int c, int height) {
        Queue<Point> queue = new LinkedList<>();

        visited[r][c] = true;

        queue.offer(new Point(r, c));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_r = p.x + dr[i];
                int next_c = p.y + dc[i];

                if (next_r >= 0 && next_r < map.length && next_c >= 0 && next_c < map[0].length) {
                    if ((map[next_r][next_c] > height) && (!visited[next_r][next_c])) {
                        visited[next_r][next_c] = true;
                        queue.offer(new Point(next_r, next_c));
                    }
                }
            }
        }
    }

}
