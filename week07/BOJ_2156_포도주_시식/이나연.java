import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        //포도주 잔의 개수 N, 포도주의 양 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        //최대로 마실 수 있는 포도주의 양 구하기
        int[] dp = new int[N + 1];
        dp[1] = A[1];
        if (N > 1) {
            dp[2] = A[1] + A[2];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + A[i], dp[i - 3] + A[i - 1] + A[i]));
        }

        System.out.println(dp[N]);
    }
}