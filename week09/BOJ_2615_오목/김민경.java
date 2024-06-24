import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// 가로, 세로, 대각선 
// 대각선 방향 고려(상향, 하향)
// 5개를 넘는 경우 고려
public class Main {
    static int[][] checkerboard;
    static int[][] dx = { { 0, 1, 1 , 1 }, { 0, -1, -1, -1 } };
    static int[][] dy = { { 1, 0, 1, -1 }, { -1, 0, -1, 1 } };
    static int solution(int i, int j, int k, int color) {
        int count = 1;

        for(int t = 0; t < 2; t++) {
            int x = i + dx[t][k];
            int y = j + dy[t][k];
            while(x >= 0 && y >= 0 && x < 19 && y < 19 && checkerboard[x][y] == color) {
                count++;
                x += dx[t][k];
                y += dy[t][k];
            }
        }   
        return count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        checkerboard = new int[19][19];
        for(int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                checkerboard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(checkerboard[i][j] != 0) {
                    for(int k = 0; k < 4; k++) {
                        if(solution(i, j, k, checkerboard[i][j]) == 5) {
                            if(k == 3) {
                                System.out.println(checkerboard[i][j]);
                                System.out.println((i + 5) + " " + (j - 3));
                            } else {
                                System.out.println(checkerboard[i][j]);
                                System.out.println((i + 1) + " " + (j + 1));
                            }
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}