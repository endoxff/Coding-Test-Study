import java.util.*;
import java.io.*;

public class Main {

	static int T;
	static int N = 30;
	static int M = 30;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][M+1];
		
		for(int i=0; i<=N; i++) 
			for(int j=0; j<=M; j++) 
				dp[i][j] = -1;
			
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(func(m, n)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int func(int n, int m) {
		
		if (dp[n][m] != -1)
			return dp[n][m];
		
		if (n != m && n == 1)
			return n;
		
		if (n == m || m == 0)
			return 1;
		
		return dp[n][m] = func(n-1, m) + func(n-1, m-1);
		
	}

}
