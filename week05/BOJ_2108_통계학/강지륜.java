import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] array;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();
	static Map<Integer, Integer> map = new LinkedHashMap<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		temp = new int[N];
		
		double sum = 0;
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(br.readLine());
			sum += array[i];
		}
		
		mergeSort(0, N-1);
		
		int totalMode;
		if (N == 1) {
			totalMode = array[0];
		} else {
			int max = Integer.MIN_VALUE;
			for(int key:map.keySet()) 
				if (max < map.get(key))
					max = map.get(key);
			
			ArrayList<Integer> maxList = new ArrayList<>();
			for(int key:map.keySet()) {
				if (map.get(key) == max)
					maxList.add(key);
			}
			
			if (maxList.size() > 1) {
				totalMode = maxList.get(1);
			}else
				totalMode = maxList.get(0);
		}
		
		sb.append(Math.round(sum/N)).append("\n");	// 산술평균
		sb.append(array[N/2]).append("\n");	// 중앙값
		sb.append(totalMode).append("\n");	// 최빈값
		sb.append(array[N-1] - array[0]).append("\n");	// 범위
		System.out.println(sb);
	}
	
	static void mergeSort(int left, int right) {
		
		if (left < right) {
			int mid = (right + left) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		
		int l = left;
		int r = mid + 1;
		int idx = left;
		
		while(l<=mid && r <= right) {
			if(array[l] < array[r]) 
				temp[idx++] = array[l++];
			else
				temp[idx++] = array[r++];
		}
		
		if (l>mid) {
			while(r<=right)
				temp[idx++] = array[r++];
		} else {
			while(l<=mid)
				temp[idx++] = array[l++];
		}
		
		for(int i=left; i<=right; i++) {
			array[i] = temp[i];
			
			if (right == N-1 && left == 0) {
				Integer cnt = map.get(array[i]);
				
				if (cnt == null) 
					map.put(array[i], 1);
				else 
					map.put(array[i], cnt+1);
			}
		}
	}

}
