import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//4200 -> 1000원 4개, 100원 2개 = 6개
//4790 -> 1000원 4개, 500원 1개, 100원 2개, 50원 1개, 10원 4개 = 12개

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int len = 0;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if(a[i] <= k) {
                len = i;
            }
        }
        
        int count = 0;
        for(int i = len ; i >= 0; i--) {
            count += k / a[i];
            k %= a[i];
        }
        System.out.println(count);
    }
}
