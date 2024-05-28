import java.io.*;

public class Main {

	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		
		for(int i=0; i<=N; i++)
			dp[i] = -1;
		
		dp[1] = 0;
		
		if (N >= 2)
			dp[2] = 1; 
		
		if (N >= 3)
			dp[3] = 1;
		
		for(int i=4; i<=N; i++) {
			if (i % 2 == 0 && i % 3 == 0) {
				dp[i] = 1+ Math.min(dp[i / 3], Math.min(dp[i - 1], dp[i / 2]));
			}
			else if (i % 2 == 0) {
				dp[i] = 1 + Math.min(dp[i-1], dp[i/2]);
			} else if (i % 3 == 0) {
				dp[i] = 1 + Math.min(dp[i-1], dp[i/3]);
			}else
			 dp[i] = 1 + dp[i-1];
		}
		
		System.out.println(dp[N]);
		
	}

}
