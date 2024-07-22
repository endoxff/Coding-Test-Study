import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken()); //상담을 완료하는데 걸리는 시간
            A[i][1] = Integer.parseInt(st.nextToken()); //상담을 했을 때 받을 수 있는 금액
        }

        int[] dp = new int[N + 5]; //상담의 최대 이익을 저장하는 dp 배열
        for (int i = N - 1; i >= 0; i--) {
            int period = A[i][0];
            int amount = A[i][1];
            if (i + period <= N) { //N+1일에는 회사에 없기 때문에, 이를 제외
                dp[i] = Math.max(dp[i + 1], dp[i + period] + amount);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }

}