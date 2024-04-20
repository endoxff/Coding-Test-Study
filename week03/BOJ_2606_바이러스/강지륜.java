import java.util.*;
import java.io.*;

public class Main {

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	
		int k = Integer.parseInt(br.readLine());	
		
		visited = new boolean[n+1];
	
		for(int i=0; i <= n; i++)
			graph.add(new ArrayList<>());
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
			Collections.sort(graph.get(start));
			Collections.sort(graph.get(end));
		}
		
		dfs(1);
		System.out.print(sum);
	}
	
	public static void dfs(int start) {
		
		visited[start] = true;
		
		for (int num : graph.get(start)) {
			if (!visited[num]) {
				sum += 1;
				dfs(num);
			}
		}
	}
}
