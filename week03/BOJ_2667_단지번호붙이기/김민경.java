import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int[][] adj;
    static boolean[][] visited;
    static int n, count;
    static int[] house;
    static int dx[]= {-1, 1, 0, 0};
	static int dy[]= {0, 0, -1, 1};

    static void dfs(int i, int j) {
        visited[i][j] = true;
        house[count]++;

        //상하좌우 검사
        for(int k = 0; k < 4; k++) {
            int x = i + dx[k]; //상하
			int y = j + dy[k]; //좌우
                
            if(x >= 0 && y >= 0 && x < n && y < n) {
				if(visited[x][y] == false && adj[x][y] == 1) {
					dfs(x,y);
				}
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        count = 0;
        house = new int[n * n];

        visited = new boolean[n][n];
        adj = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                adj[i][j] = 0;
            }
        }

         for(int i = 0; i < n; i++) {
                String st = br.readLine();
             for(int j = 0; j < n; j++) {
                adj[i][j] = st.charAt(j) - '0';
             }
         }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == false && adj[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
        
        Arrays.sort(house, 0, count); 
        
        for(int i = 0; i < count; i++) {
            System.out.println(house[i]);
        }
    }
}