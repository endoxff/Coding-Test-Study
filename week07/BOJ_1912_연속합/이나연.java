import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //N과 N개의 정수로 이루어진 수열 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //연속합 중 최댓값 구하기
        int sum = A[0];
        int max = sum;
        for (int i = 1; i < N; i++) {
            if (sum >= 0) { //sum이 양수인 경우
                sum += A[i];
            } else { //sum이 음수인 경우
                sum = A[i];
            }

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}