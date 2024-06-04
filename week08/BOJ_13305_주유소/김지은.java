import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] road = new long[n - 1];
        long[] oil = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n - 1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oil[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long min = oil[0];

        for (int i = 0; i < n - 1; i++) {
            if (oil[i] < min) {
                min = oil[i];
            }

            sum += (min * road[i]);
        }

        System.out.println(sum);

    }

}
