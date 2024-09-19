import java.util.*;
import java.io.*;

public class Main {
	
	static int T, min, totalMin, winner;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] t = new int[N];
			
			Map<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
			
			String[] split = br.readLine().split(" ");
			
			for(int j=0; j<split.length; j++) {
				int data = Integer.parseInt(split[j]);
				t[j] = data;
				
				if (map.get(data) == null) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(j);
					map.put(data, list);
				}
				else
					map.get(data).add(j);
			}
			
			ArrayList<Integer> remove = new ArrayList<>();
			
			map.forEach((key, team) -> {
				if (team.size() < 6)
					remove.add(key);
			});
			
			int[] rank = new int[N];
			int rankCnt = 1;
			
			for(int j=0; j<N; j++) 
				if (!remove.contains(t[j]))
					rank[j] = rankCnt++;
			
			
			Map<Integer, Integer> sum = new LinkedHashMap<>();
			min = Integer.MAX_VALUE;
			
			map.forEach((key, team) -> {
				int tSum = 0;
				if (team.size() == 6) {
					for(int j=0; j<4; j++) 
						tSum += rank[team.get(j)];
					
					sum.put(key, tSum);
					min = Math.min(min, tSum);
				}
			});
			
			
			totalMin = Integer.MAX_VALUE;
			ArrayList<Integer> total = new ArrayList<>();
			
			for(int j=0; j<=map.size(); j++)
				total.add(0);
			
			sum.forEach((key, value) -> {
				if (value == min) {
					value += rank[map.get(key).get(4)];
					totalMin = Math.min(totalMin, value);
					total.set(key, value);	
				}
			});
			
			for(int j=0; j<total.size(); j++) 
				if (total.get(j) == totalMin)
					winner = j;
			
			sb.append(winner).append("\n");
		}
		
		System.out.println(sb);
	}
}
