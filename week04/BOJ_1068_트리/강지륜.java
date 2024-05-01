import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static ArrayList<Integer> delTree = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		
		for(int i=0; i < N; i++) 
			tree.add(new ArrayList<>());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if (n != -1) 
				tree.get(n).add(i);
		}
			
		int delNode = Integer.parseInt(br.readLine());
		
		dfs(delNode);
		
		for(int node : delTree) {
			tree.forEach(t -> {
				if (t.contains(node)) {
					int idx = t.indexOf(node);
					t.remove(idx);
				}
			});
		}
		
		int i = 0;
		int result = 0;
		for (ArrayList<Integer> list: tree) {
			if (list.size() == 0 && ! delTree.contains(i)) 
				result++;
			i++;
		}
		System.out.print(result);
	}
	
	private static void dfs(int node) {
		
		visited[node] = true;
		delTree.add(node);
		
		for (int v : tree.get(node)) {
			if (!visited[v])
				dfs(v);
		}
		
	}

}
