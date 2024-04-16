import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new LinkedList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        System.out.println(bfs(1));
    }

    public static int bfs(int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;

        visited[s] = true;

        queue.offer(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int n : graph[u]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                    count++;
                }
            }
        }

        return count;
    }
}
