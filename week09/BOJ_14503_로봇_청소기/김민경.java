import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 청소하는 영역의 개수를 구하는 문제
// 칸은 벽 또는 빈칸
// 청소기 방향 - 동, 서, 남, 북

// 1번: 현재 칸이 청소 X - 청소함
// 2번: 주변 4칸이 다 청소 - 후진 가능, 한 칸 후진 후에 1번 or 후진 불가능, 작동 멈춤
// 3번: 주변 4칸 중 청소되지 않은 칸이 있는 경우 
// 3.1 반시계방향으로 90도 회전 ex) 북쪽->서쪽
// 3.2 앞쪽이 청소 X -> 한 칸 전진
// 3.3 1번으로 돌아감
// d = 0->북, 1->동, 2->남, 3->서

//칸 값이 0 -> 청소 X, 칸 값이 1 -> 벽

// 가장 먼저 현재 칸 find -> +1
public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };
        while(true) {
            if(room[r][c] == 0) {
                room[r][c] = 2;
                count++;
            } else {
                int i;
                for(i = 0; i < 4; i++) {
                    int x = dx[i] + r;
                    int y = dy[i] + c;
                    if(x >= 0 && y >= 0 && x < n && y < m) {
                        if(room[x][y] == 0) {
                            break;
                        }
                    }
                }
                 // 청소되지 않은 빈 칸이 없는 경우
                if(i == 4) {
                    // 후진 가능
                    int x = dx[d] + r;
                    int y = dy[d] + c;
                    if(x >= 0 && y >= 0 && x < n && y < m && room[x][y] != 1) { 
                        r = x;
                        c = y;
                    } else { //후진 불가능
                        break;
                    }
                } else { // 청소되지 않은 빈 칸이 있는 경우
                    if(d == 0) d = 3;
                    else d -= 1;
                    int x;
                    int y;
                    if(d == 0 || d == 1) {
                        x = dx[d + 2] + r;
                        y = dy[d + 2] + c;
                    } else {
                        x = dx[d - 2] + r;
                        y = dy[d - 2] + c;
                    }
                    // 앞쪽 칸이 청소되지 않은 빈 칸
                    if(x >= 0 && y >= 0 && x < n && y < m && room[x][y] == 0) { 
                        r = x;
                        c = y;
                    }
                }
            }
        }
        System.out.println(count);
    }
}