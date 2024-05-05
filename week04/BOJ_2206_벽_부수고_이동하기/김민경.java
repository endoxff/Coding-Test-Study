import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int map[][];
    static int resultMap[][];
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0});
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];
            int qz = q[2];

            for(int k = 0; k < 4; k++) {
                int x = qx + dx[k];
                int y = qy + dy[k];

                if(x >= 0 && x < n && y >= 0 && y < m) {
                    if(map[x][y] == 1) {
                        if (qz == 0 && !visited[x][y][qz]) {
                            visited[x][y][qz] = true;    // 방문 처리
                            resultMap[x][y] = resultMap[qx][qy] + 1; // 거리 측정
                            queue.offer(new int[]{x, y, 1});
                        }
                    } else {
                        if(!visited[x][y][qz]) {
                            visited[x][y][qz] = true;
                            resultMap[x][y] = resultMap[qx][qy] + 1; // 거리 측정
                            queue.offer(new int[]{x, y, qz});
                        }
                    }
                }
                if(x == n - 1 && y == m - 1){
                    System.out.print(resultMap[x][y] + 1);
                    return;
                }
            }
        }
        System.out.println(-1);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //행
        m = Integer.parseInt(st.nextToken()); //열

        if(n - 1 == 0 && m - 1 == 0){
            System.out.print(1);
            System.exit(0);
        }

        map = new int[n][m];
        resultMap = new int[n][m];
        visited = new boolean[n][m][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s =  st.nextToken();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
    }
}