import java.io.*;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int N;
	static String[][] array;
	static int[][] dir = {{1, 0}, {0, 1}, {1, 0}, {0, -1}};	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new String[N][N];
		
		for(int i=0; i<N; i++) 
			array[i] = br.readLine().split("");
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {

				for(int k=0; k<dir.length; k++) {
					int x = i + dir[k][0];
					int y = j + dir[k][1];
					
					if (x > -1 && x < N && y > -1 && y < N && !array[i][j].equals(array[x][y])) {
						String temp = array[i][j];
						array[i][j] = array[x][y];
						array[x][y] = temp;
						
						check();
							
						array[x][y] = array[i][j];
						array[i][j] = temp;
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void check() {
		for(int i=0;i<N;i++) {
			int cnt=1;
			
			String start = array[i][0];
			
			for(int j=1;j<N;j++) {
				if(start.equals(array[i][j])) {
					cnt++;
				}
				else {
					if (cnt == 5)
						System.out.println(i +", " +j);
					
					max = Math.max(cnt, max);
					start = array[i][j];
					cnt = 1;
				}
			}
			max = Math.max(cnt, max);
			if (max ==5)
				System.out.println(cnt + ",, " + i);
		}
		
		for(int i=0;i<N;i++) {
			int cnt=1;
			
			String start = array[0][i];
			
			for(int j=1;j<N;j++) {
				if(start.equals(array[j][i]))
					cnt++;
				else {
					
					max = Math.max(cnt, max);
					start = array[j][i];
					cnt = 1;
				}
			}
			max = Math.max(cnt, max);
		}
	}
}
