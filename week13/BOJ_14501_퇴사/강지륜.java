package week13;

import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] T, P, dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		dp = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			if (i + T[i] <= N) {
				for(int j= i + T[i]; j<N; j++) {
					dp[j] = Math.max(dp[i] + P[i], dp[j]);
				}
				if (i + T[i] == N)
					dp[i] += P[i];
				
			}
		}
		
		int max = dp[0];
		for(int i=0; i<N; i++)
			max = Math.max(max, dp[i]);
		
		System.out.print(max);
		
		
	}

}
