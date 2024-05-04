import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] graph = new char[n][n];
        char[][] changedGraph = new char[n][n];
        boolean[][]  visited = new boolean[n][n];
        boolean[][] changedVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = row.charAt(j);

                if (row.charAt(j) == 'G') {
                    changedGraph[i][j] = 'R';
                } else {
                    changedGraph[i][j] = row.charAt(j);
                }
            }
        }

        int cnt = 0;
        int rgCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(graph, visited, i, j);
                    cnt++;
                }

                if (!changedVisited[i][j]) {
                    bfs(changedGraph, changedVisited, i, j);
                    rgCnt++;
                }
            }
        }

        System.out.println(cnt + " " + rgCnt);

    }

    static void bfs(char[][] graph, boolean[][] visited, int row, int column) {
        Queue<Point> queue = new LinkedList<>();

        visited[row][column] = true;

        queue.offer(new Point(row, column));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int r = p.x;
            int c = p.y;
            char color = graph[r][c];

            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];

                if (nextR >= 0 && nextR < graph.length && nextC >= 0 && nextC < graph[0].length) {
                    if ((graph[nextR][nextC] == color) && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        queue.offer(new Point(nextR, nextC));
                    }
                }
            }
        }

    }

}
