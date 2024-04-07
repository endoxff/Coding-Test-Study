import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Integer> deq = new LinkedList<Integer>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            deq.offerLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int index = 1;

            Iterator iter = deq.iterator();
            while (iter.hasNext()) {
                if ((int)iter.next() == num)
                    break;

                index++;
            }

            if (index <= deq.size() / 2 + 1) {
                for (int j = 0; j < index - 1; j++) {
                    deq.offerLast(deq.pollFirst());
                    count++;
                }
                deq.pollFirst();
            } else {
                for (int j = 0; j < deq.size() - index + 1; j++) {
                    deq.offerFirst(deq.pollLast());
                    count++;
                }
                deq.pollFirst();
            }
        }

        System.out.println(count);
    }

}
