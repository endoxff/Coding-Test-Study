import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        if (N != 0) {
            st = new StringTokenizer(br.readLine());
        }
        int[] scores = new int[P + 1];
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int rank = N + 1;
        for (int i = N; i > 0; i--) {
            if (newScore < scores[i]) {
                break;
            } else if (newScore == scores[i]){
                rank = i;
                if (rank == P) {
                    rank = N + 1;
                    break;
                }
            } else {
                rank = i;
            }
        }

        if (rank > P) {
            rank = -1;
        }

        System.out.println(rank);
    }
}