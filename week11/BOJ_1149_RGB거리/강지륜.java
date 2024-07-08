import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] board; 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int j=0;
			while(st.hasMoreTokens()) 
				board[i][j++] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			board[i][0] += Math.min(board[i-1][1], board[i-1][2]);
			board[i][1] += Math.min(board[i-1][0], board[i-1][2]);
			board[i][2] += Math.min(board[i-1][0], board[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(board[N-1][0], board[N-1][1]), board[N-1][2]));
	}
}
