import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int[][] adj;
    static boolean[] visited;
    static int count = 0;

    static void dfs(int start, int v) {
        visited[start] = true;
        count++;
        for(int i = 1; i <= v; i++) {
            if(adj[start][i] == 1 && visited[i] == false) {
                dfs(i, v);
            }
        }
    }
    
    public static void main(Strzzing[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        adj = new int[v + 1][v + 1];
        visited = new boolean[v + 1];
    
        for(int i = 1; i <= v; i++) {
            visited[i] = false;
            for(int j = 1; j <= v; j++) {
                adj[i][j] = 0;
            }
        }

        for(int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            adj[c1][c2] = adj[c2][c1] = 1;
        }
        dfs(1, v);
        System.out.println(count - 1);
    }
}