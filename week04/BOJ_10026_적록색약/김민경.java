package BOJ_10026_적록색약;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 김민경 {
    static int n;
    static int red, green, blue, blind;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    

    static void bfs(int i, int j, char color) {
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
                    if(!visited[x][y] && grid[x][y] == color) {
                        queue.offer(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        if(color == 'R') {
            red++;
        } else if(color == 'G') {
            green++;
        } else if(color == 'B') {
            blue++;
        } else if(color == 'b') {
            blind++;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, grid[i][j]);
                }
            }
        }
        int d = red + green + blue;
        
        red = 0;
        green = 0;
        blue = 0;
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'R' || grid[i][j] == 'G') {
                    grid[i][j] = 'b';
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, grid[i][j]);
                }
            }
        }
        int d1 = blind + blue;

        System.out.println(d + " " + d1);
    }
}
