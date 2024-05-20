import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] array;
	static int max = 1;
	static boolean[][] visited;

	static int[] dx = {-1, 0, 1, 0};	// 상 우 하 좌	
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		visited = new boolean[N][N];
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int j=0;
			while(st.hasMoreTokens()) {
				int data = Integer.parseInt(st.nextToken());
				array[i][j++] = data;
				set.add(data);
			}
		}
		
		for(int num:set) {
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (!visited[i][j] && array[i][j] > num) {
						bfs(i, j, num);
						cnt++;
					}
					
				}
			}
			
			max = Math.max(cnt, max);
			visited = new boolean[N][N];
		}
			
		System.out.println(max);

	}
	
	static void bfs(int i, int j, int key) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			
			for (int k=0; k<4; k++) {
				int x = pos[0] + dx[k];
				int y = pos[1] + dy[k];
				
				if (x > -1 && y > -1 && x < N && y < N) {
					if (array[x][y] > key && !visited[x][y]) {
						queue.offer(new int[] {x, y});
						visited[x][y] = true;
					}
				}
			}
		}
	}
}
