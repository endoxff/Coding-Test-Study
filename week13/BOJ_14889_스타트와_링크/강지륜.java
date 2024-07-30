package week13;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] S;
	static int[] selected, notSelected;
	static boolean[] visited, visitedSelected;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		selected = new int[N/2];
		notSelected = new int[N/2];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int j=0;
			while(st.hasMoreTokens())
				S[i][j++] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		System.out.println(min);
	}

	static void dfs(int idx, int cnt) {
		
		if (cnt == N/2) {
			
			int s = 0;
			int r = 0;
			
			int k = 0;
			for(int i=0; i<N; i++)
				if (!visited[i])
					notSelected[k++] = i;
			
			for(int i=0; i<selected.length; i++) {
				for(int j = i+1; j<selected.length; j++) 
					s += S[selected[i]][selected[j]] + S[selected[j]][selected[i]];
				
			}
			
			for(int i=0; i<notSelected.length; i++) {
				for(int j = i+1; j<notSelected.length; j++) 
					r += S[notSelected[i]][notSelected[j]] + S[notSelected[j]][notSelected[i]];
			}
			
			min = Math.min(min, (s > r) ? s-r : r-s);
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt] = i;
				dfs(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
}
