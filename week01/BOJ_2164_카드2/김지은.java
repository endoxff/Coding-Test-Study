import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> que = new LinkedList<Integer>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }

        for (int i = 0; i < n - 1; i++) {
            que.poll();
            que.offer(que.poll());
        }

        System.out.println(que.poll());
    }

}
