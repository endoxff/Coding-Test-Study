import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    //7568 - 덩치
    static int[] weight;
    static int[] height;
    static int cnt;

    public static void main(String[] args) throws IOException {
        //덩치
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        weight = new int[n];
        height = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            weight[i] = Integer.parseInt(input[0]);
            height[i] = Integer.parseInt(input[1]);
        }


        cnt = 0;
        StringBuilder sb  = new StringBuilder();
        for (int j = 0; j < n ; j++) {
            cnt = 0;
            for (int i = 0; i < n ; i++) {
                if (weight[j] < weight[i] && height[j] < height[i]) {
                    cnt++;
                }
            }
            sb.append(cnt+1).append(" ");
        }
        System.out.println(sb);
    }
}