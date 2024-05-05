import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] graph;
	static int[][] virusGraph;
	 
	static int max = 0;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		dfs(0);
		System.out.println(max);
	}
	
	static void dfs(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(wall + 1);
                    graph[i][j] = 0;
                }
            }
        }
	}

	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		
		virusGraph = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	virusGraph[i][j] = graph[i][j];
                if (virusGraph[i][j] == 2) 
                	queue.add(new int[]{i, j});
            }
        }
		
		while(!queue.isEmpty()) {
			int pos[] = queue.poll();
			
			for (int i=0; i<dx.length; i++) {
				int x_1 = pos[0] + dx[i];
				int y_1 = pos[1] + dy[i];
				
				if (x_1 > -1 && x_1 < N && y_1 > -1 && y_1 < M)  {
					if (virusGraph[x_1][y_1] == 0) {
						virusGraph[x_1][y_1] = 2;
						queue.offer(new int[] {x_1, y_1});
					}
				}
			}
		}
		max = Math.max(max, count());
	}
	
	static int count() {
		int result = 0;
		for(int i=0; i<N; i++) 
			for (int j=0; j<M; j++) 
				if (virusGraph[i][j] == 0)
					result++;
		return result;
	}

}
