import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    long n;
    int count;

    Node(long n, int count) {
        this.n = n;
        this.count = count;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(bfs(a, b));
    }

    static int bfs(long a, long b) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(a, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            long n = node.n;
            int count = node.count;

            if (n == b) {
                return count;
            }

            long nextN1 = n * 2;
            long nextN2 = Long.parseLong(Long.toString(n) + "1");

            if (nextN1 <= b) {
                queue.offer(new Node(nextN1, count + 1));
            }

            if (nextN2 <= b) {
                queue.offer(new Node(nextN2, count + 1));
            }

        }

        return -1;
    }
}
