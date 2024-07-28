import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] A;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(MIN);
    }

    private static void dfs(int index, int depth) {
        if (depth == N / 2) { //축구 팀을 다 뽑은 경우
            //두 팀의 능력치 비교
            int startTeam = 0;
            int linkTeam = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) { //방문한 팀의 능력치
                        startTeam += (A[i][j] + A[j][i]);
                    } else if (!visited[i] && !visited[j]) { //방문하지 않은 팀의 능력치
                        linkTeam += (A[i][j] + A[j][i]);
                    }
                }
            }

            int diff = Math.abs(startTeam - linkTeam);
            if (diff == 0) {
                System.out.println(0);
                System.exit(0);
            }
            MIN = Math.min(MIN, diff);
            return;
        }

        //축구 팀 뽑기
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}