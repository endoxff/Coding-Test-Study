import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

	static int N, L, R;
	static int[][] country;
	static boolean[][] visited;
	static ArrayList<Point> list = new ArrayList<>();
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 위 오른쪽 아래 왼쪽
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		
		country = new int[N][N];
		
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			
			for(int j=0; j<N; j++) 
				country[i][j] = Integer.parseInt(str[j]);
		}
		
		int result = 0;
		while(true) {
			boolean check = false;
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (!visited[i][j]) {
						int sum = bfs(i, j, list);
						
						if (sum != country[i][j]) {
							for(Point p : list) 
								country[p.x][p.y] = sum / list.size();
							
							check = true;
							
						}
						list.clear();
					}
				}
			}
			
			if (!check)
				break;
			else
				result++;
			
		}
		
		System.out.println(result);
	}
	
	static int bfs(int x, int y, ArrayList<Point> selectedList) {
		
		int sum = 0;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		selectedList.add(new Point(x, y));
		visited[x][y] = true;
		sum += country[x][y];
		
		while(!q.isEmpty()) {
			Point p = q.poll();

			for(int i=0; i<dir.length; i++) {
				int px = p.x + dir[i][0];
				int py = p.y + dir[i][1];
				
				if (px > -1 && py > -1 && px < N && py < N && !visited[px][py] &&
						Math.abs(country[px][py] - country[p.x][p.y]) >= L && 
						Math.abs(country[px][py] - country[p.x][p.y]) <= R ) {
					 q.add(new Point(px, py));
					 visited[px][py] = true;
					 sum += country[px][py];
					 selectedList.add(new Point(px, py));
				}
			}	
		}	
		
		return sum;
	}
}
