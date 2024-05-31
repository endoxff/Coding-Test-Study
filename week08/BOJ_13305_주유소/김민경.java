import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1번째 도시 -> 2번째 도시: 2km, 주유는 1km 당 5원 -> 총 10원
// 2번째 도시 -> 3번째 도시: 4km, 주유는 1km 당 2원 -> 총 8원
// 총 비용: 10 + 8 = 18원

// 반복문을 돌면서 주유소의 리터 당 가격을 비교하고 더 작은 값이 나오면 min을 업데이트
// 최소 비용: min * 도로 길이

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] dist  = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] cost = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        long min = cost[0];
        long result = 0;
        for(int i = 0; i < n - 1; i++) {
            if(cost[i] < min) {
                min = cost[i];
            }
            result += dist[i] * min;
        }
        System.out.println(result);
    }
}