import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N번 집의 색 != N-1번 집의 색
// i(2 ≤ i ≤ N-1) -> 양옆에 집의 색과 같지 않음

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];
        int[][] cost = new int[n][3];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }    
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        for(int i = 1; i < n; i++) {
            // R을 선택 -> i - 1, i + 1은 G, B 중에 하나
            dp[i][0] = Math.min(dp[i - 1][1] + cost[i][0], dp[i - 1][2] + cost[i][0]);
            // G를 선택 -> i - 1, i + 1은 R, B 중에 하나
            dp[i][1] = Math.min(dp[i - 1][0] + cost[i][1], dp[i - 1][2] + cost[i][1]);
            // B를 선택 -> i - 1, i + 1은 R, G 중에 하나
            dp[i][2] = Math.min(dp[i - 1][0] + cost[i][2], dp[i - 1][1] + cost[i][2]);
        }
        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }
}