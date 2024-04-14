import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 인원 수
		int k = Integer.parseInt(st.nextToken());	// K 번째
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) 
			q.add(i);
		
		System.out.print("<");
		
		int idx = 0;
		while(!q.isEmpty()) {
			
			int data = q.peek();
			
			if( q.size() == 1 ) {
				System.out.printf("%d", data);
				q.remove();
			}
			else {
				if (idx % k != (k - 1)) {
					q.remove();
					q.add(data);
				}
				else {
					q.remove();
					System.out.printf("%d, ", data);
				}
				idx++;
				}
			}
		System.out.print(">");
	}
}
