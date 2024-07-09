package BOJ_9095_1_2_3_더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 순서과 관련 O
// 1 + 1 + .... + 1
// dp[1] = 1
// dp[2] = (1 + 1, 2) = 2
// dp[3] = (1 + 1 + 1), (2 + 1), (1 + 2), 3 = 4

// dp[4] = (1 + 1 + 1 + 1), (1 + 1 + 2), (1 + 2 + 1), (2 + 1 + 1), (2 + 2), (1 + 3), (3 + 1) = 7 -> d[1] + d[2] + d[3]
// dp[5] = (1 + 1 + 1 + 1 + 1), (1 + 1 + 1 + 2), (1 + 1 + 2 + 1), (1 + 2 + 1 + 1), (2 + 1 + 1 + 1),
// (1 + 2 + 2), (2 + 1 + 2), (2 + 2 + 1)
// (1 + 1 + 3), (1 + 3 + 1), (3 + 1 + 1), (2 + 3), (3 + 2) = 13 -> d[2] + d[3] + d[4] 
// dp[6] = d[3] + d[4] + d[5]
// dp[7] = d[4] + d[5] + d[6]
public class 김민경 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        for(int i = 1; i < 11; i++) {
            dp[i] = 0;
        }
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            for(int j = 1; j <= n; j++) {
                if(j == 1) {
                    dp[j] = 1;
                } else if (j == 2) {
                    dp[j] = 2;
                } else if (j == 3) {
                    dp[j] = 4;
                } else {
                    dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
                }
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}