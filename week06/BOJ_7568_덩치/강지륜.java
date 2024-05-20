import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] array;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N][2];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int cnt;
		
		for(int i=0; i<N; i++) {
			cnt = 1;
			for(int j=0; j<N; j++) {
				if (array[i][0] < array[j][0] && array[i][1] < array[j][1])
					cnt++;
			}
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb);
	}

}

