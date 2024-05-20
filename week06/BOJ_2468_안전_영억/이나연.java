import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] heights; //영역의 높이들을 저장하는 배열
    static boolean isSafe[][]; //안전한 영역인지 표시하는 배열

    public static void main(String[] args) throws IOException {

        //N과 영역의 높이 정보 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new int[N][N];
        int maxHeight = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                heights[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(heights[i][j], maxHeight);
            }
        }

        int maxSafeArea = 1; //가장 높은 영역 높이
        for (int i = 1; i < maxHeight; i++) {
            //물에 잠기지 않는 안전한 영역인지 표시
            checkSafe(i);
            //안전한 영역의 최대 개수 구하기
            maxSafeArea = Math.max(countSafeArea(), maxSafeArea);
        }

        System.out.println(maxSafeArea);
    }

    /*
    물에 잠기지 않는 안전한 영역인지 표시하는 메소드
     */
    private static void checkSafe(int height) {
        isSafe = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (heights[i][j] > height) {
                    isSafe[i][j] = true;
                }
            }
        }
    }

    /*
    안전한 영역의 개수를 구하는 메소드
     */
    private static int countSafeArea() {
        int count = 0;
        boolean visited[][] = new boolean[N][N];
        Queue<Place> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && isSafe[i][j]) {
                    queue.add(new Place(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Place place = queue.poll();
                        int x = place.x;
                        int y = place.y;

                        //영역의 왼쪽 탐색 (x, y - 1)
                        if (y - 1 >= 0 && !visited[x][y - 1] && isSafe[x][y - 1]) {
                            queue.add(new Place(x, y - 1));
                            visited[x][y - 1] = true;
                        }
                        //영역의 오른쪽 탐색 (x, y + 1)
                        if (y + 1 < N && !visited[x][y + 1] && isSafe[x][y + 1]) {
                            queue.add(new Place(x, y + 1));
                            visited[x][y + 1] = true;
                        }
                        //영역의 윗쪽 탐색 (x - 1, y)
                        if (x - 1 >= 0 && !visited[x - 1][y] && isSafe[x - 1][y]) {
                            queue.add(new Place(x - 1, y));
                            visited[x - 1][y] = true;
                        }
                        //영역의 아랫쪽 탐색 (x + 1, y)
                        if (x + 1 < N && !visited[x + 1][y] && isSafe[x + 1][y]) {
                            queue.add(new Place(x + 1, y));
                            visited[x + 1][y] = true;
                        }
                    }

                    count++;
                }
            }
        }

        return count;
    }

    /*
    영역의 좌표를 저장하는 클래스
     */
    static class Place {
        int x;
        int y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}