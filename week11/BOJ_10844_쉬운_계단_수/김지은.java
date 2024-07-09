import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static Long[][] dp;
    final static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new Long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        for (int i = 1; i <= 9; i++) {
            result += solution(n, i);
        }

        System.out.println(result % mod);
    }

    public static long solution(int digit, int value) {
        if (digit == 1) {
            return dp[digit][value];
        }

        if (dp[digit][value] == null) {
            if (value == 0) {
                dp[digit][value] = solution(digit - 1, 1);
            } else if (value == 9) {
                dp[digit][value] = solution(digit - 1, 8);
            } else {
                dp[digit][value] = solution(digit - 1, value - 1) + solution(digit - 1, value + 1);
            }
        }

        return dp[digit][value] % mod;
    }

}
