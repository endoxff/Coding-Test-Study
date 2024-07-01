import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //노드 개수 V, 에지 개수 E, 출발 노드의 번호 K 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        ArrayList<Edge>[] list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Edge>();
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) { //인접 리스트 초기화
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(K, 0));
        distance[K] = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int nowVertex = now.vertex;
            if (!visited[nowVertex]) {
                visited[nowVertex] = true;
                for (int i = 0; i < list[nowVertex].size(); i++) {
                    Edge tmp = list[nowVertex].get(i);
                    int next = tmp.vertex;
                    int value = tmp.value;
                    if (distance[nowVertex] + value < distance[next]) {
                        distance[next] = value + distance[nowVertex];
                        queue.add(new Edge(next, distance[next]));
                    }
                }
            }
        }

        //거리 배열 출력
        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.value > e.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}