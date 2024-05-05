import java.io.*;

public class Main {
	
	static int N;
	static boolean[][] visited;
	static String[][] graph;
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };	
	
	static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new String[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) 
			graph[i] = br.readLine().split("");
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, graph[i][j], false);
					result++;
				}
			}
		}
		
		System.out.print(result);
		
		result = 0;
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, graph[i][j], true);
					result++;
				}
			}
		}
		
		System.out.println(" "+ result);

	}
	
	static void dfs(int x, int y, String s, boolean check) {
		visited[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int x_1 = x + dx[i];
			int y_1 = y + dy[i];
			
			if (x_1 > -1 && x_1 < N && y_1 > -1 && y_1 < N) {
				if (!visited[x_1][y_1]) {
					if (check && !s.equals("B") && !graph[x_1][y_1].equals("B")) 
						graph[x_1][y_1] = s;
					
					if (graph[x_1][y_1].equals(s))
							dfs(x_1, y_1, s, check);
				}
			}
		}
	}
	
}
