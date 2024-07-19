import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static boolean[] visited;
	static int[] array;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[M+1];
		visited = new boolean[N+1];
		
		func(0);
		System.out.println(sb);
	}
	
	static void func(int cnt) {
		if (cnt == M) {
			for(int i=1; i<=M; i++)
				sb.append(array[i]).append(" ");
			sb.append("\n");
			
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[cnt+1] = i;
				func(cnt+1);
				visited[i] = false;
			}
		}
	}
}
