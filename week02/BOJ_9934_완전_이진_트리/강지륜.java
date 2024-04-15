import java.io.*;
import java.util.*;

public class Main {

	static int k;
	static int[] num;
	static List<ArrayList<Integer>> tree;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = new int[(int)Math.pow(2, k) - 1];
		
		int i = 0;
		while(st.hasMoreTokens()) 
			num[i++] = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList<>();
		for (i = 0; i < k; i++) 
			tree.add(new ArrayList<>());
		
		func(0, 0, num.length - 1);
		
		for (i = 0; i < k; i++) {
            for (int j : tree.get(i)) 
                System.out.print(j + " ");
            System.out.println();
        }
	}

	public static void func(int h, int start, int end) {
		
		if (h == k) 
			return;
		
		int mid = (start+end)/2;
		
		tree.get(h).add(num[mid]);
			
		func(h+1, start, mid-1);
		func(h+1, mid+1, end);
	}
}