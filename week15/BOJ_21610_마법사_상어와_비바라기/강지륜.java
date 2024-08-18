import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {

	static int N, M;
	static int[][] A, move;
	static ArrayList<Point> cloud = new ArrayList<>();
	static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};    // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		move = new int[M][2];
		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			
			for(int j=0; j<str.length; j++)
				A[i][j] = Integer.parseInt(str[j]);
		}
		
		for(int i=0; i<M; i++) {
			String[] str = br.readLine().split(" ");
			move[i][0] = Integer.parseInt(str[0])-1;
			move[i][1] = Integer.parseInt(str[1]);
		}
		
		cloud.add(new Point(N-2, 0));
		cloud.add(new Point(N-2, 1));
		cloud.add(new Point(N-1, 0));
		cloud.add(new Point(N-1, 1));
		
		func();
		
		int sum = 0;
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				sum += A[i][j];
		
		System.out.println(sum);
	}
	
	static void func() {
		for(int i=0; i<M; i++) {
			for(int j=0; j<cloud.size(); j++) {
				int x = cloud.get(j).x + (move[i][1] % N) * dir[move[i][0]][0];
				int y = cloud.get(j).y + (move[i][1] % N) * dir[move[i][0]][1];
				
				if (x < 0) 
					x += N;
				
				if (y < 0)
					y += N;
				
				if (x > N-1)
					x -= N;
				
				if (y > N-1)
					y -= N;

				cloud.set(j, new Point(x, y));
			}
	
			for(int j=0; j<cloud.size(); j++)
				A[cloud.get(j).x][cloud.get(j).y] += 1;
			
			ArrayList<Point> newCloud = new ArrayList<>();
			
			for(int j=0; j<cloud.size(); j++) {
				for(int k=1; k<8; k+=2) {
					int x = cloud.get(j).x + dir[k][0];
					int y = cloud.get(j).y + dir[k][1];
					
					if (x > -1 && y > -1 && x < N && y < N && A[x][y] > 0)
						A[cloud.get(j).x][cloud.get(j).y]++;
				}
			}
			
			for(int j=0; j <N; j++) {
				for(int k=0; k<N; k++) {
					if (A[j][k] >= 2 && !cloud.contains(new Point(j, k))) {
						newCloud.add(new Point(j, k));
						A[j][k] -= 2;
					}
				}
			}
			
			cloud = newCloud;
		}
	}	
}