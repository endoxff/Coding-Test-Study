import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] dfs_adj;
    static ArrayList<Integer>[] bfs_adj;
    static boolean[] dfs_visited;
    static boolean[] bfs_visited;

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        dfs_visited[start] = true;

       while(!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print(vertex + " ");

            for (int neighbor : dfs_adj[vertex]) {
                if (!dfs_visited[neighbor]) {
                    dfs(neighbor);
                }
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        bfs_visited[start] = true;

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : bfs_adj[vertex]) {
                if (!bfs_visited[neighbor]) {
                    bfs(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        dfs_adj = new ArrayList[n + 1];
        bfs_adj = new ArrayList[n + 1];
        dfs_visited = new boolean[n + 1];
        bfs_visited = new boolean[n + 1];

        //정점 번호는 1부터 N번까지
        for (int i = 1; i <= n; i++) {
            dfs_adj[i] = new ArrayList<>();
            bfs_adj[i] = new ArrayList<>();
            dfs_visited[i] = false;
            bfs_visited[i] = false;
        }

        //간선 
        for(int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int a =  Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            //무방향 그래프이니까
            dfs_adj[a].add(b);
            dfs_adj[b].add(a);

            bfs_adj[a].add(b);
            bfs_adj[b].add(a);
        }

        //방문할 수 있는 정점이 여러 개 -> 정점 번호가 작은 것을 먼저 방문
        //오름차순 정렬
        for(int i = 1; i <= n; i++){
            Collections.sort(dfs_adj[i]);
            Collections.sort(bfs_adj[i]);
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }
}