import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B;
	static int min = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		while(true) {
			if (A==B)
				break;
			else if (A > B || B == 0) {
				min = -1;
				break;
			}
				
			else {
				if (B % 2 == 0) {
					B /= 2;
					min++;
				}
					
				else {
					if ( (B - 1) % 10 == 0 ) {
						B = (B - 1) / 10;
						min++;
					} else {
						min = -1;
						break;
					}
				}
			}
		}
		
		if (min == -1)	
			System.out.println(min);
		else 
			System.out.println(min + 1);
		
	}

}
