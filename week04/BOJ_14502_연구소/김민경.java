import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] virusMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    static void dfs(int wall) {
        if(wall == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        virusMap = new int[n][m]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virusMap[i][j] = map[i][j];
                if (virusMap[i][j] == 2) {
                    //바이러스의 위치
                    queue.offer(new int[]{i, j}); 
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];

            for(int k = 0; k < 4; k++) {
                int x = qx + dx[k];
                int y = qy + dy[k];


                if(x >= 0 && x < n && y >= 0 && y < m) {
                    if(virusMap[x][y] == 0) {
                        virusMap[x][y] = 2;
                        queue.offer(new int[] {x, y});

                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }
    
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //행
        m = Integer.parseInt(st.nextToken()); //열
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }
}