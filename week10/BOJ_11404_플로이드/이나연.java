import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] distance = new int[N + 1][N + 1];
        //인접 행렬 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001; //충분히 큰 수로 저장
                }
            }
        }
        //버스 비용 정보 저장
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 시작 도시와 도착 도시를 연결하는 노선은 여러 개일 수 있으므로, 그 중 최솟값을 저장함
            if (v < distance[s][e]) {
                distance[s][e] = v;
            }
        }

        //플로이드-워셜 알고리즘 수행
        for (int k = 1; k <= N; k++) { //거쳐가는 지점
            for (int i = 1; i <= N; i++) { //시작 지점
                for (int j = 1; j <= N; j++) { //도착 지점
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (distance[i][j] == 10000001) {
                    System.out.print("0 ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}