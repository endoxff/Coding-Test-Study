import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] values = new int[N + 1];
        int[] dp = new int[K + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            values[i] = Integer.parseInt(br.readLine());
            for (int j = values[i]; j <= K; j++) {
                dp[j] += dp[j - values[i]];
            }
        }
        System.out.println(dp[K]);
    }
}