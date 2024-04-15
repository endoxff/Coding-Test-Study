import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);

        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);
    }

    public static void dfs(int v) {
        visited[v] = true;

        System.out.print(v + " ");

        for (int n = 1; n < graph[v].length; n++) {
            if (graph[v][n] != 0 && !visited[n])
                dfs(n);
        }

    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[v] = true;

        queue.offer(v);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            System.out.print(u + " ");

            for (int n = 1; n < graph[u].length; n++) {
                if (graph[u][n] != 0 && !visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
    }
}
