import java.util.*;
import java.io.*;

public class Main {
	
	static int k;
	static boolean[] visited;
	static int[] selected;
	static char[] op;
	static int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	static List<String> list = new ArrayList<>(); 
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		op = new char[k+1];
		selected = new int[k+1];
		visited = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int idx = 0;
		while(st.hasMoreTokens())
			op[idx++] = st.nextToken().charAt(0);
		
		backTracking(0, 10, 0);
		
		sb.append(list.get(list.size()-1)).append("\n").append(list.get(0));
		System.out.println(sb);
		
	}
	
	static void backTracking(int start, int end, int cnt) {
		
		if (cnt == k + 1 ) {
			String result = "";
			for(int i=0; i<cnt; i++) 
				result += Integer.toString(selected[i]);
			
			list.add(result);
			return;
		}
		
		for(int i=start; i<end; i++) {
			if (!visited[i]) {
				visited[i] = true;

				selected[cnt] = i;
				
				if (cnt == k) {
					if (op[cnt-1] == '>' && selected[cnt-1] > selected[cnt] ) {
						backTracking(start, end, cnt+1);
					} else if (op[cnt-1] == '<' && selected[cnt-1] < selected[cnt])
						backTracking(start, end, cnt+1);
				} else  {
					if (op[cnt] == '<') {
						backTracking(i, 10,cnt+1);
					} else if (op[cnt] == '>')
						backTracking(0, i, cnt+1);
				}

				visited[i] = false;
			}
		}
	}

}
