import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static ArrayList<Point> clouds = new ArrayList<>();
    static ArrayList<Point> hasClouds = new ArrayList<>();
    static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeClouds(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            bibaragi(n, d - 1, s);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    static void bibaragi(int n, int d, int s) {
        moveCloudsAndRain(n, d, s);
        copyWaterMagic(n);
        removeWater(n);
    }

    static void makeClouds(int n) {
        clouds.add(new Point(n - 1, 0));
        clouds.add(new Point(n - 1, 1));
        clouds.add(new Point(n - 2, 0));
        clouds.add(new Point(n - 2, 1));
    }

    static void moveCloudsAndRain(int n, int d, int s) {
        for (Point cloud: clouds) {
            cloud.x = (n + cloud.x + dr[d] * (s % n)) % n;
            cloud.y = (n + cloud.y + dc[d] * (s % n)) % n;
            map[cloud.x][cloud.y]++;
        }
    }

    static void copyWaterMagic(int n) {
        for (Point cloud: clouds) {
            hasClouds.add(cloud);
            for (int i = 1; i < 8; i += 2) {
                int checkR = cloud.x + dr[i];
                int checkC = cloud.y + dc[i];

                if (checkR >= 0 && checkR < n && checkC >= 0 && checkC < n && map[checkR][checkC] != 0) {
                    map[cloud.x][cloud.y]++;
                }
            }
        }

        clouds.clear();
    }

    static void removeWater(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2 && !hasClouds.contains(new Point(i, j))) {
                    clouds.add(new Point(i, j));
                    map[i][j] -= 2;
                }
            }
        }

        hasClouds.clear();
    }
}