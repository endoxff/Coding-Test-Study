package week02.BOJ_2075_N번째_큰_수;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        String[] strings1 = new String[N];
        for(int i = 0; i < N; i++) {
            strings1 = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(strings1[j]));
            }
        }
        for(int i = 0; i < N - 1; i++) {
            pq.remove();
        }
        System.out.println(pq.peek());
    }
}
