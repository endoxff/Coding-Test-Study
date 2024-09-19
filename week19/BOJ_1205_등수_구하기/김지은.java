import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println("1");
            return;
        }

        Integer[] rank = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getScore(rank, n, score, p));

    }

    static int getScore(Integer[] rank, int n, int score, int p) {
        Arrays.sort(rank, Collections.reverseOrder());

        if (n == p && score <= rank[rank.length - 1]) {
            return -1;
        }

        int place = 1;

        for (int i = 0; i < n; i++) {
            if (rank[i] > score) {
                place++;
            } else {
                break;
            }
        }

        if (place > p) {
            return -1;
        }

        return place;
    }

}
