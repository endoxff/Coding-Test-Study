import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Long> heap = new PriorityQueue<Long>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            if (x != 0) {
                heap.offer(x);
            } else {
                if (heap.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(heap.poll()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

}
