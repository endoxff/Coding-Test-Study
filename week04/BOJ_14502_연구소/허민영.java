import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};

    static int originalMap[][];
    static int n, m;
    static int maxSafeZone = Integer.MIN_VALUE; //최대값을 찾기 위한 최솟값 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        originalMap = new int[n][m];


        //원본 맵
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs호출
        dfs(0);

        System.out.println(maxSafeZone);
    }

    //벽을 세울 dfs
    private static void dfs(int wallCnt) {

        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs(wallCnt + 1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    //바이러스 퍼트릴 bfs
    private static void bfs() {
        Queue<Node> q = new LinkedList<>();

        //바이러스 있는 x,y좌표를 큐에 넣어놓음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalMap[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        int copyMap[][] = new int[n][m];

        //copyMap에 깊은 복사
        for (int i = 0; i < n; i++) {
            copyMap[i] = originalMap[i].clone();
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];

                if (0 <= cx && cy >= 0 && cx < n && cy < m) {
                    if (copyMap[cx][cy] == 0) {
                        copyMap[cx][cy] = 2;
                        q.add(new Node(cx, cy));
                    }
                }
            }
        }

        //SafeZone 확인
        funcSafeZone(copyMap);


    }

    //안전지역 개수 확인
    private static void funcSafeZone(int[][] copyMap) {
        int safeZone = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        if (maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}