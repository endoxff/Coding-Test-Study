import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int row;
    int column;
    int count;

    Node(int row, int column, int count) {
        this.row = row;
        this.column = column;
        this.count = count;
    }
}

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String map_row = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = map_row.charAt(j);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int town = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((map[i][j] == '1') && (!visited[i][j])) {
                    list.add(bfs(i, j));
                    town++;
                }
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(town);
        System.out.println(sb);
    }

    public static int bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        int cnt = 1;

        visited[r][c] = true;

        queue.offer(new Node(r, c, cnt++));

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_r = n.row + dr[i];
                int next_c = n.column + dc[i];

                if (next_r >= 0 && next_r < map.length && next_c >= 0 && next_c < map[0].length) {
                    if ((map[next_r][next_c] == '1') && (!visited[next_r][next_c])) {
                        visited[next_r][next_c] = true;
                        queue.offer(new Node(next_r, next_c, cnt++));
                    }
                }
            }
        }

        return cnt - 1;
    }

}
