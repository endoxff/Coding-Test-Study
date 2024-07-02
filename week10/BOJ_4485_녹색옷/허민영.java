import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //4485 - 녹색 옷 입은 애가 젤다지?
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;

        }

        //비용이 적은 노드가 큐에서 먼저 나옴
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        int idx=1;
        while(!(line = br.readLine()).equals("0")) {
            n = Integer.parseInt(line);
            map = new int[n][n];

            StringTokenizer st = null;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cost = bfs();
            sb.append("Problem " + idx + ": " + cost+"\n");
            idx++;
        }
        System.out.println(sb.toString());
    }

    static int bfs() {
        Queue<Node> q = new PriorityQueue<>();
        int[][] move = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }

        q.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];

        while(!q.isEmpty()) {
            Node pos = q.poll();
            int px = pos.x;
            int py = pos.y;
            int cost = pos.cost;

            //[n-1][n-1]에 도달하면 cost 리턴
            if(px == n-1 && py == n-1) {
                return cost;
            }

            //상하좌우 확인
            for(int i=0; i<4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                //범위확인
                if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;

                //비용에 map값을 더한 값이 move 배열의 값보다 작으면 move배열에 값 대입
                if(cost+map[ny][nx] < move[ny][nx]) {
                    move[ny][nx] =cost+map[ny][nx];
                    q.add(new Node(nx,ny,cost+map[ny][nx])); //그런다음 큐에 집어 넣는다.
                }

            }
        }
        return -1;
    }
}