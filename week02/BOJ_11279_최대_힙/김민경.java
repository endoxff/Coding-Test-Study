package week02.BOJ_11279_최대_힙;
import java.util.*;
import java.io.*;
public class 김민경 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            pq.offer(x);

            if(x == 0) {
                arr.add(pq.poll());
            }
        }
        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
