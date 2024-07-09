import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] triangle;
    static Integer[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        System.out.println(getMaxSum(0, 0));
    }

    public static int getMaxSum(int r, int c) {
        if (r == n - 1) {
            return dp[r][c];
        }

        if (dp[r][c] == null) {
            dp[r][c] = Math.max(getMaxSum(r + 1, c), getMaxSum(r + 1, c + 1)) + triangle[r][c];
        }

        return dp[r][c];
    }

}
