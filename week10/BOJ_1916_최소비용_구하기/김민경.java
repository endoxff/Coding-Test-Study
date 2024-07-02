package BOJ_1916_최소비용_구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 출발 도시의 번호 도착 도시의 번호 버스 비용

class Node implements Comparable<Node>{
    int end;
    int cost;

    public Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
public class 김민경 {
    static int n, m;
    static ArrayList<Node>[] arr; 
    static int[] dist;
    static boolean[] visited;

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new Node(start,0));
        dist[start] = 0;
            
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.end] = true;
            
            for(Node n : arr[node.end]) {
                if(visited[n.end]) {
                    continue;
                }
                if(dist[n.end] > dist[node.end] + n.cost) {
                    dist[n.end] = dist[node.end] + n.cost;
                    pq.add(new Node(n.end, dist[n.end]));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for(int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

        StringTokenizer st = null;
        for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[start].add(new Node(end, cost));
		}
        st = new StringTokenizer(br.readLine());
        int start_city = Integer.parseInt(st.nextToken());
        int end_city = Integer.parseInt(st.nextToken());

        dijkstra(start_city);
        System.out.println(dist[end_city]);
    }
}
