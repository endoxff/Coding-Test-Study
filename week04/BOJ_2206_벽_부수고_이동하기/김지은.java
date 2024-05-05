import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int count;
    boolean broken;

    Node(int x, int y, int count, boolean broken) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.broken = broken;
    }
}

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] brokenVisited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        brokenVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();

        visited[start][end] = true;

        queue.offer(new Node(start, end, 1, false));

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int r = n.x;
            int c = n.y;

            if (r == map.length - 1 && c == map[0].length - 1) {
                return n.count;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];

                if (nextR >= 0 && nextR < map.length && nextC >= 0 && nextC < map[0].length) {
                    if (map[nextR][nextC] == '0') {
                        if (!n.broken && !visited[nextR][nextC]) {
                            visited[nextR][nextC] = true;
                            queue.offer(new Node(nextR, nextC, n.count + 1, false));
                        } else if (n.broken && !brokenVisited[nextR][nextC]) {
                            brokenVisited[nextR][nextC] = true;
                            queue.offer(new Node(nextR, nextC, n.count + 1, true));
                        }

                    } else {
                        if (!n.broken) {
                            brokenVisited[nextR][nextC] = true;
                            queue.offer(new Node(nextR, nextC, n.count + 1, true));
                        }
                    }
                }
            }
        }

        return -1;
    }

}
