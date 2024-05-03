import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int deletedNode;
    static int leaf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int root = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());

            if (p == -1) {
                root = i;
            } else {
                graph[p].add(i);
            }
        }

        deletedNode = Integer.parseInt(br.readLine());
        graph[deletedNode].clear();

        dfs(root);

        System.out.println(leaf);
    }

    static void dfs(int node) {
        visited[node] = true;
        int nearNode = 0;

        for (int v: graph[node]) {
            if ((v != deletedNode) && !visited[v]) {
                nearNode++;
                dfs(v);
            }
        }

        if (node != deletedNode && nearNode == 0) {
            leaf++;
        }
    }
}
