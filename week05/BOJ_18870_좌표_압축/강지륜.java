import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] copyArray;
	static int[] array;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		copyArray = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Set<Integer> set = new LinkedHashSet<>();
		for(int i=0; i<N; i++) {
			int data = Integer.parseInt(st.nextToken());
			set.add(data);
			copyArray[i] = data;
		}

		array = new int[set.size()];
		temp = new int[set.size()];
		
		int i=0;
		for(int num : set) 
			array[i++] = num;
		
		mergeSort(0, array.length-1);
		
		for(int num:array) 
			set.add(num);
		
		for(int num:copyArray) 
			sb.append(binarySearch(num, 0, array.length-1)).append(" ");
		
		System.out.println(sb);
	}
	
	static int binarySearch(int key, int low, int high) {
		
		int mid;
		
		if (low <= high) {
			mid = (high+low) / 2;
			
			if (key == array[mid]) {
				return mid;
			}
			
			if (key > array[mid]) 
				return binarySearch(key, mid + 1, high);
			else 
				return binarySearch(key, low, mid - 1 );
		}
		return -1;
	}
	
	static void mergeSort(int left, int right) {
		
		if (left<right) {
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
		
		while(l<=mid && r <=right) {
			if (array[l] < array[r])
				temp[idx++] = array[l++];
			else
				temp[idx++] = array[r++];
		}
		
		if (l > mid) {
			while(r <= right) 
				temp[idx++] = array[r++];
		} else {
			while(l <= mid) 
				temp[idx++] = array[l++];
		}
		
		for(int i=left; i<=right; i++)
			array[i] = temp[i];
	}
}
