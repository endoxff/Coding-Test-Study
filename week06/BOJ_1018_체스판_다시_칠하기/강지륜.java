import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static String[][] array;
	static String[][] whiteBoard;
	static String[][] blackBoard;
	static int min = Integer.MAX_VALUE;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new String[N][M];
		whiteBoard = new String[8][8];
		blackBoard = new String[8][8];
		
		for(int i=0; i<8; i++) {
			if (i % 2 ==0) {
				whiteBoard[i] = "WBWBWBWB".split("");
				blackBoard[i] = "BWBWBWBW".split("");
			}
			else {
				whiteBoard[i] = "BWBWBWBW".split("");
				blackBoard[i] = "WBWBWBWB".split("");
			}
		}
		
		for(int i=0; i<N; i++) 
			array[i] = br.readLine().split("");
		
		for(int i = 0; i <= (N-8); i++) {
			for(int j = 0; j <= (M-8); j++) {
				int result = Math.min(compareWhite(i, j), compareBlack(i, j));
				if (min > result)
					min = result;
			}
		}
		
		System.out.println(min);
		
	}
	
	static int compareWhite(int x, int y) {
		
		int white_x = 0;
		int white_y = 0;
		int result = 0;
		for(int i = x; i < x + 8 ; i++) {
			white_y = 0;
			for(int j = y; j < y + 8; j++) {
				if(!array[i][j].equals(whiteBoard[white_x][white_y])) 
					result++;
				white_y++;
			}
			white_x++;
		}
		
		return result;
		
	}
	
	static int compareBlack(int x, int y) {
		
		int black_x = 0;
		int black_y = 0;
		int result = 0;
		for(int i = x; i < x + 8; i++) {
			black_y = 0;
			for(int j = y; j < y + 8; j++) {
				if(!array[i][j].equals(blackBoard[black_x][black_y]))
					result++;
				black_y++;
			}
			black_x++;
		}
		
		return result;
		
	}

}

