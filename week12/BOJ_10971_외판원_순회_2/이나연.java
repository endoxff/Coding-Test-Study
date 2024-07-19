import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
        }

        System.out.println(min);
    }

    private static void dfs(int start, int now, int sum, int depth) {
        if (depth == N - 1) {
            if (W[now][start] != 0) {
                sum += W[now][start];
                min = Math.min(min, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[now][i] > 0) {
                visited[i] = true;
                dfs(start, i, sum + W[now][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}