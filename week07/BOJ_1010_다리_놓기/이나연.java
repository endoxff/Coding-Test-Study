import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[][] memo; //조합값을 저장하는 배열

    public static void main(String[] args) throws IOException {

        //조합 초기값
        memo = new long[31][31];
        for (int i = 0; i < 31; i++) {
            memo[0][i] = 1;
            memo[i][0] = 1;
            memo[i][i] = 1;
        }

        //테스트 케이스 개수 T, 강의 서쪽 사이트 개수 N, 동쪽 사이트 개수 M 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(combination(M, N));
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static long combination(int n, int m) {
        if (memo[n][m] == 0) {
            memo[n][m] = combination(n - 1, m - 1) + combination(n - 1, m);
        }
        return memo[n][m];
    }
}