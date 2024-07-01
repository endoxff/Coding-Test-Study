import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] list = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int c_v = current.vertex;
            if (c_v == end) {
                break;
            }
            if (!visited[c_v]) {
                visited[c_v] = true;
                for (int i = 0; i < list[c_v].size(); i++) {
                    Edge tmp = list[c_v].get(i);
                    int next = tmp.vertex;
                    int value = tmp.value;
                    if (distance[c_v] + value < distance[next]) {
                        distance[next] = distance[c_v] + value;
                        queue.add(new Edge(next, distance[next]));
                    }
                }
            }
        }

        System.out.println(distance[end]);
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        public int compareTo(Edge e) {
            if (this.value > e.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}