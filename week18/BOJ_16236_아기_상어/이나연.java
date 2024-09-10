import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N]; // 지도
        Node shark = null; // 아기 상어

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 지도 입력과 동시에 아기 상어 위치 저장
                if (map[i][j] == 9) {
                    shark = new Node(i, j);
                    // 아기 상어 위치를 저장했으면 0으로 초기화 하여 이동 할 수 있게 함
                    map[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 0, 0, 1}; // 4방향 탐색
        int[] dy = {0, -1, 1, 0};

        int answer = 0, sharkSize = 2, eatCount = 0;

        while (true) {
            int x = Integer.MAX_VALUE; // 다음 먹을 물고기 위치
            int y = Integer.MAX_VALUE;
            int d = Integer.MAX_VALUE;

            Queue<Node> queue = new LinkedList<>();
            int[][] dist = new int[N][N]; // 이동 거리 저장 및 사이클 방지

            queue.add(new Node(shark.x, shark.y)); // 현재 아기 상어 위치 부터

            while (!queue.isEmpty()) { // bfs 탐색
                Node now = queue.poll();
                for (int k = 0; k < 4; k++) { // 4방향 순회
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    // 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.
                    if (map[nx][ny] > sharkSize) continue;
                    // 이미 방문한 위치는 다시 방문 x (사이클 방지)
                    if (dist[nx][ny] != 0) continue;

                    dist[nx][ny] = dist[now.x][now.y] + 1; // 이동 횟수 저장

                    if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                        if (d > dist[nx][ny]) { // 가장 가까운 물고기를 먹는다.
                            d = dist[nx][ny];
                            x = nx;
                            y = ny;
                        } else if (d == dist[nx][ny]) { // 거리가 같은 경우
                            if (nx == x) { // 가장 왼쪽의 물고기
                                if (y > ny) {
                                    x = nx;
                                    y = ny;
                                }
                            } else if (nx < x) { // 가장 위의 물고기
                                x = nx;
                                y = ny;
                            }
                        }
                    }

                    queue.add(new Node(nx, ny));
                }
            }

            if (x == Integer.MAX_VALUE && y == Integer.MAX_VALUE) {
                break; // 먹을 물고기가 없는 경우
            }

            answer += dist[x][y];
            map[x][y] = 0;

            shark.x = x;
            shark.y = y;

            eatCount++;

            if (eatCount == sharkSize) { // 상어 크기 증가
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(answer);
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}