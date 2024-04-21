import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            field = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                field[r][c] = 1;
            }

            int cnt = 0;

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if ((field[j][l] == 1) && (!visited[j][l])) {
                        bfs(j, l);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();

        visited[r][c] = true;

        queue.offer(new Point(r, c));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_r = p.x + dr[i];
                int next_c = p.y + dc[i];

                if (next_r >= 0 && next_r < field.length && next_c >= 0 && next_c < field[0].length) {
                    if ((field[next_r][next_c] == 1) && (!visited[next_r][next_c])) {
                        visited[next_r][next_c] = true;
                        queue.offer(new Point(next_r, next_c));
                    }
                }
            }
        }
    }

}
