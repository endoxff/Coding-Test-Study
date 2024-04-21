import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] adj;
    static boolean[][] visited;
    static int m, n;
    static int[] dx = {-1, 1, 0, 0}; //상하
    static int[] dy = {0, 0, -1, 1}; //좌우

    static void dfs(int i, int j) {
        visited[i][j] = true;

            //상하좌우 검사
        for(int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
        
            if(x >= 0 && y >= 0 && x < m && y < n) {
                if(visited[x][y] == false && adj[x][y] == 1) {
                    dfs(x, y);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        
        int[] count = new int[t + 1];
        int index = 0;

        for(int num = 0; num < t; num++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); //배추 위치 개수

            visited = new boolean[m][n];
            adj = new int[m][n];

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adj[x][y] = 1;
            }

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j] == false && adj[i][j] == 1) {
                        dfs(i, j);
                        count[index]++;
                    }
                }
            }
            index++;
        }
        for(int i = 0; i < t; i++) {
            System.out.println(count[i]);
        }
    }
}