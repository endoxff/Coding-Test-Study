import java.util.*;
import java.io.*;

public class Main {

	static int T, n;	
	static long[][] dp;
	static int[][] score;
	static int[][] dir = {{-1, -1}, {1, -1}};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			
			n = Integer.parseInt(br.readLine());
			
			score = new int[2][n];
			dp = new long[2][n];
			
			for(int j=0; j<2; j++) {
				String[] str = br.readLine().split(" ");
				
				for(int k=0; k<str.length; k++)
					score[j][k] = Integer.parseInt(str[k]);
			}
			
			dp[0][0] = (long) score[0][0];
			dp[1][0] = (long) score[1][0];
			
			if (n == 1) 
				sb.append(Math.max(dp[0][0], dp[1][0])).append("\n");
			else if(n == 2) {
				sb.append(Math.max(score[0][0] + score[1][1], score[1][0] + score[0][1])).append("\n");
			} else {
				dp[0][1] = (long) score[0][1] + dp[1][0];
				dp[1][1] = (long) score[1][1] + dp[0][0];
				
				for(int j=2; j<n; j++) {
					for(int k=0; k<2; k++) {
						for(int h=0; h<dir.length; h++) {
							int x = k + dir[h][0];
							int y = j + dir[h][1];
							
							if (x > -1 && y > -1 && x < 2 && y < n) {
								if (k == 0)	
									dp[k][j] = Math.max(Math.max(dp[x][y], dp[k][j-2]), dp[k+1][j-2]) + (long) score[k][j];  
								else 
									dp[k][j] = Math.max(Math.max(dp[x][y], dp[k-1][j-2]), dp[k][j-2]) + (long) score[k][j];   
							}
							
						}
					}
				}
				
				long max = 0;
				
				for(int j=0; j<2; j++) 
					for(int k=0; k<n; k++) 
						max = Math.max(max, dp[j][k]);
				
				sb.append(max).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
