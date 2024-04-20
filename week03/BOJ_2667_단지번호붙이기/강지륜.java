import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] graph;
	static boolean[][] visited;
	static int N;
	
	static int sum = 0;
	
	static int[] dx = {-1, 0, 1, 0};		
	static int[] dy = {0, 1, 0, -1};		

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			
			for (int j = 0; j < str.length; j++) 
				graph[i][j] = Integer.parseInt(str[j]);
		}
		
		
		List<Integer> list = new ArrayList<>();
		
		for (int i=0; i<N; i++)  {
			for (int j=0; j<N; j++) {
				if (graph[i][j] == 1 && !visited[i][j]) {
					sum++;
					dfs(i, j);
					list.add(sum);
					sum = 0;
				}
					
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		
		for (int i= 0; i<list.size(); i++) 
			System.out.println(list.get(i));
		
	}
	
	public static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		for (int i=0; i < 4; i++) {
			int x_1 = x + dx[i];
			int y_1 = y + dy[i];
			
			if (x_1 < N && y_1 < N && x_1 > -1 && y_1 > -1 ) {
				if (graph[x_1][y_1] == 1 && !visited[x_1][y_1]) {
					sum ++;
					dfs(x_1, y_1);
				}
			}
		}
	}

}
