import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] region;
    static int n;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];

            for(int k = 0; k < 4; k++) {
                int x = qx + dx[k];
                int y = qy + dy[k];
                if(x >= 0 && x < n && y >= 0 && y < n) {
                    if(!visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[] {x, y});
                    }
                } 
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        region = new int[n][n];
        visited = new boolean[n][n];

        int maxHeight = 1;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int height = Integer.parseInt(st.nextToken());
                region[i][j] = height;
                maxHeight = Math.max(height, maxHeight);
            }
        }
        
        if(maxHeight > 100) {
            System.out.println(1);
            return;
        }
        
        int count = 0;
        int max = 1;
        for(int h = 1; h <= maxHeight; h++) {
            count = 0;
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(region[i][j] <= h) {
                        visited[i][j] = true;
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            max = max < count ? count : max;
        }
        System.out.println(max);
    }
}