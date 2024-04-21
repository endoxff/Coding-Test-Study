import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] adj;
    static boolean[][] visited;
    static int n, m;
    static int count = 0;
    static int dx[]= {-1, 1, 0, 0};
	static int dy[]= {0, 0, -1, 1};

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            int q[] = queue.poll();
            int qx = q[0];
            int qy = q[1];

            for(int k = 0; k < 4; k++) {
                int x = qx + dx[k]; //상하
                int y = qy + dy[k]; //좌우
                    
                if(x > 0 && y > 0 && x <= n && y <= m) {
                    if(visited[x][y] == false && adj[x][y] == 1) {
                        queue.offer(new int[] {x, y});
        		        adj[x][y] = adj[qx][qy] + 1;
                		visited[x][y] = true;
                    }
                }
            }
        }
    }    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= m; j++) {
                adj[i][j] = s.charAt(j - 1) - '0';
            }
        }
        
        bfs(1, 1);
    
        System.out.println(adj[n][m]);
    }
}