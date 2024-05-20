
import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static String[][] array;
	static int max = 1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new String[N][M];
		
		for(int i=0; i<N; i++)
			array[i] = br.readLine().split("");
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int idx = 1;
				while(j + idx < M && i + idx < N) {
					if (array[i][j].equals(array[i][j+idx]) && 
							array[i][j+idx].equals(array[i+idx][j]) &&
							array[i][j].equals(array[i+idx][j+idx])) {
						int result = (idx+1) * (idx+1);
						if (max < result)
							max = result;
					}
					idx++;
				}
			}
		}
		
		System.out.println(max); 
		

	}
}
