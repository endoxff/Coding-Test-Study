import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] D = new int[N][N];
        D[0][0] = Integer.parseInt(br.readLine());
        int max = D[0][0];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
                if (j - 1 >= 0) {
                    D[i][j] += Math.max(D[i - 1][j - 1], D[i - 1][j]);
                } else {
                    D[i][j] += D[i - 1][j];
                }
                max = Math.max(max, D[i][j]);
            }
        }
        System.out.println(max);
    }
}
