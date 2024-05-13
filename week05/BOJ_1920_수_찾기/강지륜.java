import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] array;
	static int[] sorted; 	// 합치는 과정에서 정렬하여 원소를 담을 임시배열 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		array = new int[N];
		sorted = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		for(int i=0; i<N; i++) 
			array[i] = Integer.parseInt(st.nextToken()); 

		mergeSort(0, array.length-1);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<M; i++) 
			binarySearch(Integer.parseInt(st.nextToken()), 0, N-1);
		
		System.out.println(sb);
	}
	
	static void binarySearch(int key, int low, int high) {
		
		int mid;
		
		if (low <= high) {
			mid = (low + high)/2;
			
			if (key == array[mid]) {
				sb.append(1).append('\n');
				return;
			}
			
			if (key > array[mid]) {
				binarySearch(key, mid+1, high);
			} else {
				binarySearch(key, low, mid-1);
			}
		} else 
			sb.append(0).append('\n');
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
		
		int l = left;		// 왼쪽 부분 리스트 시작점
		int r = mid + 1;	// 오른쪽 부분 리스트 시작점
		int idx = left;		// 채워넣을 배열의 인덱스
		
		while(l <= mid && r <= right) {
			if (array[l] < array[r]) 
				sorted[idx++] = array[l++];
			else 
				sorted[idx++] = array[r++];
		}
		
		if(l > mid) {
			while (r<=right) 
				sorted[idx++] = array[r++];
		} else {
			while (l<=mid) 
				sorted[idx++] = array[l++];
		}
		
		for(int i=left; i<=right; i++) 
			array[i] = sorted[i];
	}

}
