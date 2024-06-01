import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        //정수 A, B 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        //A를 B로 바꾸는데 필요한 연산의 최솟값 구하기
        int answer = -1;
        Queue<Calculation> queue = new LinkedList<>();
        queue.add(new Calculation(A, 1));
        while (!queue.isEmpty()) {
            Calculation cal = queue.poll();
            int nowN = cal.n;
            int nowCount = cal.count;
            if (nowN == B) {
                answer = nowCount;
                break;
            }

            //연산 1: 2를 곱한다
            int cal1 = nowN * 2;
            if (cal1 <= B) {
                queue.add(new Calculation(cal1, nowCount + 1));
            }
            //연산 2: 1을 수의 가장 오른쪽에 추가한다
            long cal2 = Long.parseLong(String.format(nowN + "1")); //연산 2의 경우, int 범위를 초과할 수 있기 때문에 long으로 선언
            if (cal2 <= B) {
                queue.add(new Calculation((int) cal2, nowCount + 1));
            }
        }

        System.out.println(answer);
    }

    static class Calculation {
        int n; //연산하려는 수
        int count; //연산의 횟수

        public Calculation(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}