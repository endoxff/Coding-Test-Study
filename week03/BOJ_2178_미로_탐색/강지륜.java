import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};	// 상 우 하 좌	
	static int[] dy = {0, 1, 0, -1};	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			
			for (int j=0; j< str.length; j++) 
				graph[i][j] = Integer.parseInt(str[j]);
		}
		
		bfs(0, 0);
		
		System.out.println(graph[N-1][M-1]);
		

	}
	
	public static void bfs(int i, int j) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			
			
			for (int k=0; k<4; k++) {
				int x = point[0] + dx[k];
				int y = point[1] + dy[k];
				
				if (x > -1 && y > -1 && x < N && y < M) {
					if (graph[x][y] == 1 && ! visited[x][y]) {
						queue.offer(new int[] {x, y});
						graph[x][y] = graph[point[0]][point[1]] + 1;
						visited[x][y] = true;
					}
					
				}
			}
			
			
		}
	}

}
