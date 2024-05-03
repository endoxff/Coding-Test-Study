import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int x;
    int y;
    int day;

    Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class Main {
    static int[][] storage;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<Tomato> queue = new LinkedList<>();
    static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        storage = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());

                if (storage[i][j] == 1) {
                    queue.offer(new Tomato(i, j, 0));
                }
            }
        }

        bfs();

        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(day);
        } else {
            System.out.println("-1");
        }

    }

    static void bfs() {
        day = 0;

        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            day = t.day;

            for (int i = 0; i < 4; i++) {
                int nextR = t.x + dr[i];
                int nextC = t.y + dc[i];

                if (nextR >= 0 && nextR < storage.length && nextC >= 0 && nextC < storage[0].length) {
                    if (storage[nextR][nextC] == 0) {
                        storage[nextR][nextC] = 1;
                        queue.add(new Tomato(nextR, nextC, day + 1));
                    }
                }
            }
        }
    }

}
