import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] A;
    static ArrayList<Point> chicken;
    static ArrayList<Point> home;
    static boolean[] visited;
    static Point[] picked;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        //도시의 크기 N, 치킨집의 개수 M 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //도시의 정보 입력
        chicken = new ArrayList<>(); //치킨집 좌표 저장
        home = new ArrayList<>(); //집 좌표 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) { //집일 경우
                    home.add(new Point(i, j));
                } else if (type == 2) { //치킨집일 경우
                    chicken.add(new Point(i, j));
                }
            }
        }

        //도시의 치킨 거리의 최솟값 구하기
        visited = new boolean[chicken.size()]; //치킨집 방문 여부
        picked = new Point[M]; //방문한 치킨집 저장
        dfs(0, 0);
        System.out.println(MIN);
    }

    private static void dfs(int index, int depth) {
        if (depth == M) {
            //최소 거리 구하기
            int[] minDistance = new int[home.size()]; //최소 거리를 저장하는 배열
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < home.size(); j++) {
                    int distance = (int) (Math.abs(home.get(j).getX() - picked[i].getX()) + Math.abs(home.get(j).getY() - picked[i].getY()));
                    if (i == 0) {
                        minDistance[j] = distance;
                    } else {
                        minDistance[j] = Math.min(minDistance[j], distance);
                    }
                }
            }

            //치킨 거리의 합 구하기
            int sum = 0;
            for (int i = 0; i < home.size(); i++) {
                sum += minDistance[i];
            }
            MIN = Math.min(MIN, sum);
            return;
        }

        //치킨집 고르기
        for (int i = index; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                picked[depth] = chicken.get(i);
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}