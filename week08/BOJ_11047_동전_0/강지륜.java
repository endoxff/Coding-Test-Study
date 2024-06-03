import java.util.*;
import java.io.*;

public class Main {
		
	static int N, K;
	static int[] array;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N];

		for(int i=0; i<N; i++) 
			array[i] = Integer.parseInt(br.readLine());
		
		int result = 0;
		while (K != 0) {
			
			int maxIndex = 0;
			
			for(int i=N-1; i>=0; i--)
				if (K >= array[i]) {
					maxIndex = i;
					break;
				}
			
			while(K  >= array[maxIndex]) {
				result++;
				K -= array[maxIndex];
			}
		}
		
		System.out.println(result);
		
	}

}
