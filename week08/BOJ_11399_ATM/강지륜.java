import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static List<Integer> people = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) 
			people.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(people);
		
		int[] time = new int[N];
		time[0] = people.get(0);
		
		for(int i=1; i<N; i++) 
			time[i] = time[i-1] + people.get(i);
		
		int result = 0;
		
		for(int i=0; i<N; i++)
			result += time[i];
		
		System.out.println(result);
	}

}
