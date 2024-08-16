import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {

	static int N, M;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] selected;
	static ArrayList<Point> house = new ArrayList<>();
	static ArrayList<Point> chicken = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int j=0;
			while(st.hasMoreTokens()) {
				int data = Integer.parseInt(st.nextToken());
				
				if (data == 1)
					house.add(new Point(i, j));
				
				if (data == 2)
					chicken.add(new Point(i, j));
				
				j++;
			}
		}
		
		visited = new boolean[chicken.size()];
		dfs(0, 0);
		System.out.println(min);
	}
	
	static void dfs(int index, int cnt) {
		if (cnt == M) {
			
			int[] minArray = new int[house.size()];
			Arrays.fill(minArray, Integer.MAX_VALUE);
			
			for(int i=0; i < M; i++)
				for(int j=0; j<house.size(); j++) 
					minArray[j] = Math.min(minArray[j], Math.abs(selected[i][0] - house.get(j).x) + Math.abs(selected[i][1] - house.get(j).y));
				
			int sum = 0;
			for(int i=0; i<minArray.length; i++)
				if (minArray[i] != Integer.MAX_VALUE) sum += minArray[i];
			
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=index; i<chicken.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt][0] = chicken.get(i).x;
				selected[cnt][1] = chicken.get(i).y;
				dfs(i + 1 , cnt+1);
				visited[i] = false;
			}
		}
		
		
	}
}
