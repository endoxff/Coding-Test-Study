import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    //인접리스트
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;

    static void dfs(int data) {
        visited[data] = true;

        for(int i = 0; i < tree.get(data).size(); i++) {
            int d = tree.get(data).get(i);
            if(!visited[d]) {
                dfs(tree.get(data).get(i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        tree = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<Integer>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            tree.add(new ArrayList<Integer>());
            int pN = Integer.parseInt(st.nextToken());
            if(pN == -1) {
                continue;
            }
            tree.get(pN).add(i);
        }
        int dN = Integer.parseInt(br.readLine());
        dfs(dN);

        int count = 0;
        for(int i = 0; i < n; i++) {
            tree.get(i).remove(Integer.valueOf(dN));
            if(!visited[i] && tree.get(i).size() == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}