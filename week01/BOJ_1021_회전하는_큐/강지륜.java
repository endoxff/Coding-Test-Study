import java.util.*;
import java.io.*;

public class Main {
	
	static Deque<Integer> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 큐의 크기
		int m = Integer.parseInt(st.nextToken());	// 뽑아내려고 하는 수의 개수
		
		for (int i = 1; i <= n; i++) 
			deque.add(i);
		
		List<Integer> pickList = new ArrayList<>();
		st = new StringTokenizer(br.readLine()); 
		while(st.hasMoreTokens()) 
			pickList.add(Integer.parseInt(st.nextToken()));
		
		int result = 0;
		
		for (int i = 1; i <= m; i++) {
			int pickNum = pickList.get(i-1);
			
			if (deque.peek() == pickNum) 
				pick();
			else {
				int idx = 0;
				
				for (int num: deque) {
					if (num == pickNum)
						break;
					idx++;
				}
				
				while(!deque.isEmpty()) {
					if (deque.peek() == pickNum)
						break;
					
					if (deque.size() == 3) {
						if (deque.peek() != pickNum && deque.peekLast() != pickNum) 
							shiftLeft();
						else if (deque.peekLast() == pickNum) 
							shiftRight();
					}
					else {
						if (idx <= deque.size() / 2) 
							shiftLeft();
						else 
							shiftRight();
					}
					result++;
				}
				pick();
			}
		}
		System.out.println(result);
	}


	public static void pick() {
		deque.poll();
	}
	
	public static void shiftLeft() {
		int data = deque.peek();
		deque.poll();
		deque.add(data);
	}
	
	public static void shiftRight() {
		int data = deque.peekLast();
		deque.pollLast();
		deque.offerFirst(data);
	}

}





