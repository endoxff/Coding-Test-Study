import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	
	static int[][] graph;
	static boolean[][] visited;
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };	

	static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int j = 0;
			while(st.hasMoreTokens()) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		for (int i=0; i<N; i++) 
			for (int j=0; j<M; j++) 
				if (!visited[i][j] && graph[i][j] == 1) 
					queue.offer(new int[] {i, j});
				
		
		for (int i=0; i<N; i++) 
			for (int j=0; j<M; j++) 
				if (!visited[i][j] && graph[i][j] == 1) 
					bfs(i, j);
		
		int result = 0;
		
		for (int i=0; i<N; i++) {
			if (result == -1)
				break;
			
			for (int j=0; j<M; j++) {
				if (graph[i][j] == 0) {
					result = -1;
					break;
				} 

				if (graph[i][j] > result && graph[i][j] != 1)
					result = graph[i][j];
			}
		}
		
		if (result > 0) 
			System.out.println(result-1);
		else
			System.out.println(result);
	}

	static void bfs(int x, int y) {
		
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			for (int i=0; i < dx.length; i++) {
				int x_1 = pos[0] + dx[i];
				int y_1 = pos[1] + dy[i];
				
				if (x_1 > -1 && x_1 < N && y_1 > -1 && y_1 < M) {
					if (!visited[x_1][y_1] && graph[x_1][y_1] == 0) {
						queue.offer(new int[] {x_1, y_1});
						visited[x_1][y_1] = true;
						graph[x_1][y_1] = graph[pos[0]][pos[1]] + 1;
					}
				}
			}
		}
	}
}
