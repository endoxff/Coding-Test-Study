import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int count = 0;
        int min = Integer.MAX_VALUE;
        boolean flag1 = true;
        boolean flag2 = false;
        char color= ' ';
        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {
                for(int k = 0; k < 2; k++) {
                    for(int p = i; p < i + 8; p++) {
                        for(int l = j; l < j + 8; l++) {
                            color = flag1 ? 'W' : 'B';

                            if(board[p][l] == color) {
                                count++;
                            }
             
                            if(l != j + 7) {       
                                flag2 = flag1 ? true : false;
                                flag1 = flag1 ? false : true;    
                            }
                        }
                    }
                    flag2 = flag1 ? true : false;
                    flag1 = flag1 ? false : true;
                    min = count < min ? count : min;
                    count = 0;
               }
            }
        }
        System.out.println(min);
    }
}