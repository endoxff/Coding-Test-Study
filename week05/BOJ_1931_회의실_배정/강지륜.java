import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] array;
	static int[][] temp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		array = new int[N][2];
		temp = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			array[i] = new int[] {start, end};
		}
		
		mergeSort(0, N-1);
		
		int result = 1;
		int end = array[0][1];
		System.out.println(array[0][0] + ", " + array[0][1]);
		
		for(int i=1; i<N; i++) {
			if (end <= array[i][0]) {
				System.out.println(i + ": " + array[i][0] + ", " + array[i][1]);
				result++;
				end = array[i][1];
			}
		}
		
		System.out.println(result);
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
		
		while(l <= mid && r <= right) {
			if (array[l][1] == array[r][1]) {
				if (array[l][0] < array[r][0])
					temp[idx++] = array[l++]; 
				else
					temp[idx++] = array[r++]; 
			}
			else if (array[l][1] < array[r][1]) {
				temp[idx++] = array[l++]; 
			} else {
				temp[idx++] = array[r++];
			}
		}
		
		if (l > mid) {
			while(r<=right)
				temp[idx++] = array[r++];
		}else {
			while(l<=mid)
				temp[idx++] = array[l++];
		}
		
		for(int i=left; i<=right; i++)
			array[i] = temp[i];
	}

}
