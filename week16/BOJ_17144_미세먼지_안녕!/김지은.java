import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] house;
    static ArrayList<Integer> airPurifier = new ArrayList<>();
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        house = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
                if (house[i][j] == -1) {
                    airPurifier.add(i);
                }
            }
        }

        for (int i = 0; i < t; i++) {
            spreadOfDust(r, c);
            clean(r, c);
        }

        System.out.println(getTotalDust(r, c));

    }

    static void spreadOfDust(int r, int c) {
        int[][] temp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (house[i][j] > 0) {
                    int spreadAmount = house[i][j] / 5;
                    int spreadCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int nextR = i + dr[d];
                        int nextC = j + dc[d];

                        if (nextR >= 0 && nextR < r && nextC >= 0 && nextC < c && house[nextR][nextC] != -1) {
                            temp[nextR][nextC] += spreadAmount;
                            spreadCount++;
                        }
                    }
                    temp[i][j] += house[i][j] - (spreadAmount * spreadCount);
                } else {
                    temp[i][j] += house[i][j];
                }
            }
        }

        house = temp;
    }

    static void clean(int r, int c) {
        int top = airPurifier.get(0);

        for (int i = top - 1; i > 0; i--) {
            house[i][0] = house[i - 1][0];
        }

        for (int i = 0; i < c - 1; i++) {
            house[0][i] = house[0][i + 1];
        }

        for (int i = 0; i < top; i++) {
            house[i][c - 1] = house[i + 1][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            house[top][i] = house[top][i - 1];
        }

        house[top][1] = 0;

        int bottom = airPurifier.get(1);

        for (int i = bottom + 1; i < r - 1; i++) {
            house[i][0] = house[i + 1][0];
        }

        for (int i = 0; i < c - 1; i++) {
            house[r - 1][i] = house[r - 1][i + 1];
        }

        for (int i = r - 1; i > bottom; i--) {
            house[i][c - 1] = house[i - 1][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            house[bottom][i] = house[bottom][i - 1];
        }

        house[bottom][1] = 0;
    }

    static int getTotalDust(int r, int c) {
        int totalDust = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                totalDust += house[i][j];
            }
        }

        return totalDust + 2;
    }
}
