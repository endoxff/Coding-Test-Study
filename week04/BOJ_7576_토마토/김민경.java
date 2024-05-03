import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static Queue<int[]> queue;

    static void bfs() {
        while(!queue.isEmpty()) {
            int q[] = queue.poll();

            int qx = q[0];
            int qy = q[1];

            for(int k = 0; k < 4; k++) {
                int x = qx + dx[k];
                int y = qy + dy[k];

                if(x >= 0 && x < n && y >= 0 && y < m) {
                    if(!visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[] {x, y});
                        box[x][y] = box[qx][qy] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); //열
        n = Integer.parseInt(st.nextToken()); //행
        
        box = new int[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        bfs();

        int max = -1;
        int flag = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 0) {
                    max = -1;
                    flag = 1;
                    break;
                }
                if(max < box[i][j]) {
                    max = box[i][j];
                }
            }
            if(flag == 1) {
                break;
            }
        }

        if(max == 0 || max == -1) {
            System.out.println(-1);
        } else {
            System.out.println(max - 1);
        }
    }
}
