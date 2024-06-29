import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] distance = new int[N][N];
        //인접 행렬 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //플로이드-워셜 알고리즘 수행
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (distance[i][k] == 1 && distance[k][j] == 1) {
                        distance[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

}