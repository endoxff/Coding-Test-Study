import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
//p1 = 3분 p2 = 1분 p3 = 4분 p4 = 3분 p5 = 2분
//정렬 -> 1 2 3 3 4
//1분(P1) -> 1분(P1) + 2분(P2) -> 3분(P1 + P2) + 3분(P3) -> 6분 (P1 + P2 + P3) + 3분(P4) + 9분(P1 + P2 + P3 + P4) + 4분(P5)
//최솟값: 1 + 3 + 6 + 9 + 13 = 32
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] p = new int[n];
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);

        int sum = p[0];
        for(int i = 1; i < n; i++) {
            p[i] += p[i - 1];
            sum += p[i];
        }
        System.out.println(sum);
    }
}