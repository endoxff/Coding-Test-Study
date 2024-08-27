import java.util.*;
import java.io.*;

public class Main {

	static int M;
	static List<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			String[] str = br.readLine().split(" ");
			
			switch(str[0]) {
			case "add" :
				add(Integer.parseInt(str[1]));
				break;
			case "remove":
				remove(Integer.parseInt(str[1]));
				break;
			case "check":
				check(Integer.parseInt(str[1]));
				break;
			case "toggle":
				toggle(Integer.parseInt(str[1]));
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}
		}
		
		System.out.println(sb);
	}
	
	static void add(int x) {
		if (!list.contains(x))
			list.add(x);
	}
	
	static void remove(int x) {
		if (list.contains(x))
			list.remove(list.indexOf(x));
	}
	
	static void check(int x) {
		if (list.contains(x))
			sb.append(1);
		else sb.append(0);
		
		sb.append("\n");
	}
	
	static void toggle(int x) {
		if (list.contains(x))
			list.remove(list.indexOf(x));
		else
			list.add(x);
	}
	
	static void all() {
		list.clear();
		
		for(int i=1; i<=20; i++)
			list.add(i);
	}
	
	static void empty() {
		list.clear();
	}
}