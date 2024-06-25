import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, d, x, y;
	static int[][] board;
	static int cnt = 0;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 상 우 하 좌
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			int j=0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) 
				board[i][j++] = Integer.parseInt(st.nextToken());
		}
		
		
		while(true) {
			if (board[x][y]==0) {
				board[x][y] = 2;
				cnt++;
			}
	
			int notClean = 0;
			for(int i = 0; i < dir.length; i++) {
				int dx =  x + dir[i][0];
				int dy =  y + dir[i][1];
				
				if (dx > -1 && dx > -1 && dx < N && dy < M) 
					if (board[dx][dy] == 0)
						notClean++;
			}
			
			if (notClean == 0) {
				int i = x;
				int j = y;
				
				switch(d) {
				case 0:
					i += 1;
					break;
				case 1:
					j -= 1;
					break;
				case 2:
					i -= 1;
					break;
				case 3:
					j += 1;
					break;
				}
				
				if (i > -1 && j > -1 && i < N && j < M) {
					if (board[i][j] == 1)
						break;
					else {
						x = i;
						y = j;
					}
				}
			} else {
				switch(d) {
				case 0:
					d = 3;
					break;
				case 1:
					d = 0;
					break;
				case 2:
					d = 1;
					break;
				case 3:
					d = 2;
					break;
				}
				
				int i = x;
				int j = y;
				switch(d) {
				case 0:
					i -= 1;
					break;
				case 1:
					j += 1;
					break;
				case 2:
					i += 1;
					break;
				case 3:
					j -= 1;
					break;
				}
				
				if (i > -1 && j > -1 && i < N && j < M) {
					if (board[i][j] == 0) {
						x = i;
						y = j;
					}
						
				}	
			}
		}
		
		System.out.println(cnt);
	}
}
