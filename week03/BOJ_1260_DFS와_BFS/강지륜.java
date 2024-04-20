import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		
		for (int i=0; i<=n; i++) 
			graph.add(new ArrayList<Integer>());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph.get(start).add(end);
			graph.get(end).add(start);
			Collections.sort(graph.get(start));
			Collections.sort(graph.get(end));
		}

		dfs(v);
        
		visited = new boolean[n+1];
		
		System.out.println();
		
		bfs(v);
	}

	public static void dfs(int start) {
		
		visited[start] = true;
		System.out.print(start + " ");
		
		for (int num : graph.get(start)) {
			if (!visited[num]) {
				dfs(num);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int result = queue.poll();
			System.out.print(result + " ");
			
			for (int num : graph.get(result)) {
				if (!visited[num]) {
					queue.offer(num);
					visited[num] = true;
				}
			}
		}
	}
}
