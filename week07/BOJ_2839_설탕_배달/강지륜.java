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
		
		dp[3] = 1;
		
		if (N >= 5)
			dp[5] = 1;
		
		if (N != 7 && N != 4)
			System.out.println(func(N));
		else 
			System.out.println(-1);
		 
	}
	
	static int func(int num) {
		
		if (dp[num] != -1)
			return dp[num];
		
		if (num % 5 == 3)
			return dp[num] = func(num - 5) + 1;
		else if (num % 5 == 0)
			return dp[num] = func(num - 5) + 1;
		else 
			return dp[num] = func(num - 3) + 1;
	}

}
