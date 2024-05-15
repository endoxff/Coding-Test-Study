import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //전체 사람의 수 N, 각 사람의 몸무게와 키 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] big = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            big[i][0] = Integer.parseInt(st.nextToken()); //몸무게 입력
            big[i][1] = Integer.parseInt(st.nextToken()); //키 입력
        }

        //자기보다 더 큰 덩치의 사람 수 구하기
        int[] count = new int[N]; //자기보다 더 큰 덩치의 사람 수를 저장하는 배열
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //몸무게와 키 비교
                if (big[i][0] < big[j][0] && big[i][1] < big[j][1]) {
                    count[i]++;
                }
            }
        }

        //순위 출력 (순위는 자기보다 더 큰 덩치의 사람 수 + 1)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(count[i] + 1);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
