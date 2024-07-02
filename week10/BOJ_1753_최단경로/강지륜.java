import java.util.*;
import java.io.*;

class NodeClass implements Comparable<NodeClass> {	
	int index;		// 정점 번호
	int cost; 		// 가중치
	
	public NodeClass(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	// 우선 순위 기준 -> cost(가중치)가 적은 순으로
	@Override
	public int compareTo(NodeClass o) {
		return Integer.compare(this.cost, o.cost);
	}
}

public class Main {
	
	static int V, E, K;
	static int INF = Integer.MAX_VALUE;
	static Map<Integer, ArrayList<NodeClass>> graph = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		// 1. 그래프 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());	// 노드 수
		E = Integer.parseInt(st.nextToken());	// 간선 수
		
		st = new StringTokenizer(br.readLine());	
		
		K = Integer.parseInt(st.nextToken());	// 시작 노드
		
		for(int i=1; i<=V; i++) 
			graph.put(i, new ArrayList<>());
		
		for(int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new NodeClass(end, cost));
		}
		
		dijstra(K);
		
		System.out.println(sb);
	}
	
	static void dijstra(int index) {
		
		PriorityQueue<NodeClass> pq = new PriorityQueue<>();
		int[] dist = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		
		Arrays.fill(dist, INF);
		dist[index] = 0;
		
		pq.offer(new NodeClass(index, 0));
		
		while(!pq.isEmpty()) {
			
			NodeClass curr = pq.poll();
			
			if (visited[curr.index]) 
				continue;
			
			visited[curr.index] = true;
			
			for(NodeClass next : graph.get(curr.index) ) {
				if (dist[next.index] > dist[curr.index] + next.cost ) 
					dist[next.index] = dist[curr.index] + next.cost;
				
				pq.offer(new NodeClass(next.index, dist[next.index]));
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF)
				sb.append("INF").append("\n");
			else 
				sb.append(dist[i]).append("\n");
		}
	}
}
