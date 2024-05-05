import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        //2206번 - 벽 부수고 이동하기
        // (연구소랑 비슷한 문제 같아서 비슷하게 풀이해봤다가 시간초과 났었어서 다시시도)
        //bfs로 시도

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        visited = new boolean[n][m][2]; //벽을 뚫었는지 안뚤었는지
        ans = -1;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        bfs();
        System.out.println(ans);
    }
    // visited[][][0] : 벽을 부수지 않은 경우 방문 처리
    // visited[][][1] : 벽을 부순 경우 방문 처리

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1,false)); //시작점 큐에 넣기
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n-1 && node.y == m-1) {
                ans = node.dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int ndist = node.dist + 1;


                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0) {
                        if (!node.broke) {
                            if (!visited[nx][ny][0]) { //만약 벽을 부순적이 없고 지나간 적이 없는 경우
                                visited[nx][ny][0] = true;
                                queue.add(new Node(nx, ny, ndist, false));
                            }
                        } else {
                            if (!visited[nx][ny][1]) { //만약 벽을 부순적이 있고 지나간 적이 없는 경우
                                visited[nx][ny][1] = true;
                                queue.add(new Node(nx, ny, ndist, true));
                            }
                        }
                    }else{ //인접한 곳이 벽이고 지나간 적이 없는 경우
                        if(!node.broke){
                            if(!visited[nx][ny][0]){
                                visited[nx][ny][0] = true;
                                queue.add(new Node(nx,ny,ndist,true));
                            }
                        }

                    }
                }
            }
        }
    }

    public static class Node {
        int x, y, dist;
        boolean broke;

        Node(int x, int y, int dist, boolean broke) {
            this.x = x;
            this.y = y;
            this.dist = dist; //이동거리
            this.broke = broke; //벽 부슨 여부
        }
    }
}