import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //N * M 크기의 직사각형 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] square = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                square[i][j] = tmp[j] - '0';
            }
        }

        //꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형의 길이 찾기
        int length = Math.min(N, M); //구하려는 정사각형의 길이 중 가장 큰 수
        while (length > 1) {
            int k = length - 1;
            for (int i = 0; i < N - k; i++) {
                for (int j = 0; j < M - k; j++) {
                    if (square[i][j] == square[i][j + k]
                            && square[i][j + k] == square[i + k][j]
                            && square[i + k][j] == square[i + k][j + k]) {
                        System.out.println(length * length);
                        return;
                    }
                }
            }
            length--;
        }

        System.out.println(length * length);
    }

}