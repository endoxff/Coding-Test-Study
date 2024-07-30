package week13;

import java.io.*;

public class Main {

	static int N, B, C;
	static int[] A;
	static long min = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		String[] str = br.readLine().split(" ");
		
		for(int i=0; i<str.length; i++)
			A[i] = Integer.parseInt(str[i]);

		str = br.readLine().split(" ");
		
		B = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		for(int i=0; i<N; i++) {
			A[i] -= B;
			min ++;
			
			if (A[i] > 0) {
				if (A[i] % C == 0)
					min += (long)(A[i] / C);
				else 
					min += (long)(A[i] / C + 1);
			}
		}	
		
        System.out.println(min);		
	}
}
