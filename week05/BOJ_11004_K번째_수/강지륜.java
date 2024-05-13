import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[] array;
	static int[] temp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int i = 0;
		
		while(st.hasMoreTokens()) 
			array[i++] = Integer.parseInt(st.nextToken());
		
		mergeSort(0, N-1);
		
		System.out.print(array[K-1]);
		
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
			if (array[l] <= array[r]) 
				temp[idx++] = array[l++];
			else 
				temp[idx++] = array[r++];
		}
		
		if(l > mid) {
			while (r <= right) 
				temp[idx++] = array[r++];
		} else {
			while (l <= mid) 
				temp[idx++] = array[l++];
		}
		
		for(int i=left; i<=right; i++) 
			array[i] = temp[i];
	}
 
}
