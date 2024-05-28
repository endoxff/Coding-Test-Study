import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] array;
	static int[] dp;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) 
			array[i] = Integer.parseInt(st.nextToken());

		dp[0] = array[0];
		max = Math.max(max, dp[0]);
		
		for(int i=1; i<N; i++) {
			dp[i] = Math.max(dp[i-1] + array[i], array[i]);
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
 	}
	

}
