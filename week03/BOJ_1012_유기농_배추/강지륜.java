import java.util.*;
import java.io.*;

public class Main {
	
	static int M, N;
	static int[][] graph;
	static boolean[][] visited;
	static int[] pointX = {-1, 0, 1, 0};	// 상 우 하 좌
	static int[] pointY = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		
		// T 만큼 반복
		for (int i = 0; i < T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());	// 가로 길이
			N = Integer.parseInt(st.nextToken());	// 세로 길이
			int K = Integer.parseInt(st.nextToken());	// 배추가 심어져 있는 위치의 개수

			// 2차원 배열 선언
			graph = new int[M][N];
			visited = new boolean[M][N];
			
			// 배추가 심어져 있는 곳 지정
			for (int j = 0 ; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				graph[x][y] = 1;
			}
			
			int result = 0;
			for (int k=0; k< M; k++) {
				for (int j=0; j<N; j++) {
					if (graph[k][j] == 1 && !visited[k][j]) {
						dfs(k, j);
						result++;
					}
				}
			}
			
			System.out.println(result);
			
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int dx = x + pointX[i];
			int dy = y + pointY[i];
			
			if (dx >= 0 && dy >= 0 && dx < M && dy < N) {
				if (graph[dx][dy] == 1 && !visited[dx][dy]) {
					dfs(dx, dy);
				}
			}	
		}
		
	}

}
