import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static boolean[] visited;
	static int[] operator;
	static int[] selectedOperator;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		operator = new int[N-1];
		visited = new boolean[N-1];
		selectedOperator = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int i=0;
		while(st.hasMoreTokens())
			arr[i++] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int idx = 0;
		for(i=0; i<4; i++) {
			int data = Integer.parseInt(st.nextToken());
			
			if (data != 0) 
				for(int j=0; j<data; j++)
					operator[idx++] = i;
		}
		
		func(0);
		
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}
	
	static void func(int cnt) {
		
		if (cnt == N-1) {
			int result = arr[0];
			for(int i=0; i<selectedOperator.length; i++) {
				
				switch(selectedOperator[i]) {
				case 0:
					result += arr[i+1];
					break;
				case 1:
					result -= arr[i+1];
					break;
				case 2 :
					result *= arr[i+1];
					break;
				case 3:
					if (result < 0) 
						result = (result * -1) / arr[i+1] * -1;
					else 
						result /= arr[i+1];
					break;
				}
				
			}		
			min = Math.min(min, result);
			max = Math.max(max, result);
			
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selectedOperator[cnt] = operator[i];
				func(cnt+1);
				visited[i] = false;
			}
		}
	}


}