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

    Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {
    static boolean[][] maze;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        maze = new boolean[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String maze_row = br.readLine();

            for (int j = 0; j < m; j++) {
                if (maze_row.charAt(j) == '1') {
                    maze[i][j] = true;
                } else {
                    maze[i][j] = false;
                }

            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();

        visited[x][y] = true;

        queue.offer(new Node(x, y, 1));

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (n.x == maze.length - 1 && n.y == maze[0].length - 1) {
                return n.count;
            }

            for (int i = 0; i < 4; i++) {
                int next_x = n.x + dx[i];
                int next_y = n.y + dy[i];

                if (next_x >= 0 && next_x <= maze.length - 1 && next_y >= 0 && next_y <= maze[0].length - 1) {
                    if ((maze[next_x][next_y]) && (!visited[next_x][next_y])) {
                        visited[next_x][next_y] = true;
                        queue.offer(new Node(next_x, next_y, n.count + 1));
                    }
                }
            }

        }

        return 0;
    }
}
