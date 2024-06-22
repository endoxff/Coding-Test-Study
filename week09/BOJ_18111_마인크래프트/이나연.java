import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //세로 N, 가로 M, 인벤토리의 블록 개수 B, 땅의 높이 배열 ground 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] ground = new int[N][M];
        int min = 256; //땅의 높이의 최솟값
        int max = 0; //땅의 높이의 최댓값
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(ground[i][j], min);
                max = Math.max(ground[i][j], max);
            }
        }

        int time = Integer.MAX_VALUE; //땅을 고르는데 걸리는 시간의 최솟값
        int height = 0;// 땅의 높이
        for (int k = min; k <= max; k++) {
            int block = B; //인벤토리 속 블록의 개수
            int count = 0; //땅을 고르는데 걸리는 시간
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ground[i][j] < k) { //현재 땅의 높이가 만들 층보다 낮을 경우
                        count += k - ground[i][j];
                        block -= k - ground[i][j];
                    } else if (ground[i][j] > k) { //현재 땅의 높이가 만들 층보다 높을 경우
                        count += 2 * (ground[i][j] - k);
                        block += ground[i][j] - k;
                    }
                }
            }
            if (block < 0) {
                break;
            }

            time = Math.min(time, count);
            if (time == count) {
                height = k;
            }
        }

        System.out.println(time + " " + height);
    }
}