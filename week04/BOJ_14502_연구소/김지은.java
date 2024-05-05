import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] copyMap;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int safeZone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);

        System.out.println(safeZone);
    }

    static void buildWall(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        copyMap = new int[map.length][map[0].length];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                copyMap[i][j] = map[i][j];

                if (map[i][j] == 2) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int r = p.x;
            int c = p.y;

            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];

                if (nextR >= 0 && nextR < copyMap.length && nextC >= 0 && nextC < copyMap[0].length) {
                    if (copyMap[nextR][nextC] == 0) {
                        copyMap[nextR][nextC] = 2;
                        queue.offer(new Point(nextR, nextC));
                    }
                }
            }
        }

        findSafeZone();
    }

    static void findSafeZone() {
        int sz = 0;

        for (int i = 0; i < copyMap.length; i++) {
            for (int j = 0; j < copyMap[0].length; j++) {
                if (copyMap[i][j] == 0) {
                    sz++;
                }
            }
        }

        if (sz >= safeZone) {
            safeZone = sz;
        }
    }
}
