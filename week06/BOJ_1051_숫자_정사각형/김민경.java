import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] rect = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                rect[i][j] = s.charAt(j) - '0';
            }
        }

        int len = n < m ? n : m;
        for(int i = len; i > 0; i--) {
            for(int k = 0; k <= n - i; k++) { 
                for(int t = 0; t <= m - i; t++) {
                    if(rect[k][t] == rect[k][i + t - 1] && rect[k][t] == rect[i + k - 1][t] && rect[k][t] == rect[i + k - 1][i + t - 1]) {
                        System.out.println(i * i);
                        return;
                    }
                }
            }
        }
    }
}