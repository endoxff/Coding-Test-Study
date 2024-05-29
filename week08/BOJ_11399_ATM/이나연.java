import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //사람의 수 N과 각 사람이 돈을 일출하는데 걸리는 시간 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값 구하기
        Arrays.sort(A);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            result += sum;
        }

        System.out.println(result);
    }
}