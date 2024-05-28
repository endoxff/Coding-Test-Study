import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(combination(m, n)).append("\n");
        }

        System.out.println(sb);
    }

    static int combination(int m, int n) {
        if (dp[m][n] > 0) {
            return dp[m][n];
        }

        if (n == m || n == 0) {
            return 1;
        }

        dp[m][n] = combination(m - 1, n - 1) + combination(m - 1, n);

        return dp[m][n];
    }

}
