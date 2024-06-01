import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //도시의 개수 N, 도로의 길이, 주유소의 리터당 가격 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N]; //도로의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        int[] cost = new int[N]; //주유소의 리터당 가격
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0; //제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용
        int i = 0;
        while (i < N - 1) {
            int j = i;
            long distanceSum = distance[j];
            int currentCost = cost[j++];
            while (j < N - 1 && currentCost <= cost[j]) {
                distanceSum += distance[j++];
            }
            result += cost[i] * distanceSum;
            i = j;
        }

        System.out.println(result);
    }
}