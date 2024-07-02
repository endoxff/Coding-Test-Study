import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int r;
    int c;
    int w;

    Node(int r, int c, int w) {
        this.r = r;
        this.c = c;
        this.w = w;
    }
}

public class Main {
    static int[][] cave;
    static int[][] dist;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int t = 1;

        while (n != 0) {
            cave = new int[n][n];
            dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            sb.append("Problem " + t + ": ").append(dijkstra()).append("\n");

            n = Integer.parseInt(br.readLine());
            t++;
        }

        System.out.println(sb);
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));

        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int r = n.r;
            int c = n.c;
            int w = n.w;

            if (dist[r][c] < w) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < cave.length && nc >= 0 && nc < cave[0].length) {
                    if (w + cave[r][c] < dist[nr][nc]) {
                        dist[nr][nc] = w + cave[r][c];
                        pq.offer(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }

        return dist[cave.length - 1][cave.length - 1] + cave[cave.length - 1][cave.length - 1];
    }

}
