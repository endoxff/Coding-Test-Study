import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //1010 - 다리 놓기
    static int k;
    static int n;
    static int m;

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());


        for (int i = 0; i < k; i++) {

            String[] input = br.readLine().split(" ");
            // m개중 n개를 뽑는 경우 ->  nCr 에서 n = m, r = n
            n = Integer.parseInt(input[0]); // n = r
            m = Integer.parseInt(input[1]); // m = n
            sb.append(BC(m,n)).append("\n");
        }
        System.out.println(sb);
    }

    private static int BC(int n, int r) {

        if(dp[n][r] >0){
            return dp[n][r];
        }

        if(n ==r || r == 0){
            return dp[n][r] = 1;
        }

        return dp[n][r] = BC(n-1,r-1) + BC(n-1,r);
    }
}