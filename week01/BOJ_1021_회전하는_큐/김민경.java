package week01.BOJ_1021_회전하는_큐;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int count = 0;
		int N = sc.nextInt();
		int M = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
			arr.add(i);
		}

        int[] pick = new int[M];
        for(int i = 0; i < M; i++) {
            pick[i] = sc.nextInt();
        }

        for(int i = 0; i < M; i++) {
            int index = arr.indexOf(pick[i]);
            int half_index;

            if(index <= half_index) {
                for(int j = 0; j < index; j++) {
					int temp = arr.remove(0);
					arr.add(temp);
					count++;
				}
            } else {
                for(int j = 0; j < arr.size() - index; j++) {
					int temp = arr.remove(arr.size() - 1);
                    arr.add(0, temp);
					count++;
				}
            }
            arr.remove(0);
        }
        System.out.println(count);
    }
}
