package BOJ_11399_ATM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
//p1 = 3분 p2 = 1분 p3 = 4분 p4 = 3분 p5 = 2분
//정렬 -> 1 2 3 3 4
//1분(자기 거) -> 1분(전 거) + 2분(자기거) -> 3분(전 거) + 3분(자기 거) -> 6분 (전 거) + 3분(자기 거) + 9분(전 거) + 4분(자기 거)
// 1 + 3 + 6 + 9 + 13 = 32
public class 김민경 {
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