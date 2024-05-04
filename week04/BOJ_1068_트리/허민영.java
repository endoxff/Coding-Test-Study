import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int delete;
    static int parent[];
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];

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
                graph[i].add(p);
                graph[p].add(i);
            }
        }

        delete = Integer.parseInt(br.readLine());

        if (delete == root) {
            System.out.println(0);
            return;
        } else {
            dfs(root);
        }
        System.out.println(ans);


    }


    //삭제한 노드는 탐색하지 않는다는 것이 포인트
    private static void dfs(int root) {
        visited[root] = true;
        int nodes = 0;
        for (int c : graph[root]) {
            if (c != delete && !visited[c]) { //delete할 노드가 아니고, 방문한 적도 없다면
                nodes++;
                dfs(c);
            }
        }
        if (nodes == 0) {
            ans++;
        }
    }
}