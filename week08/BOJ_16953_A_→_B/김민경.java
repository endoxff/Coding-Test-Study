import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 1;
        while(a < b) {
            if(b % 2 == 0) {
                b /= 2;
            } else if(b % 10 == 1){
                b /= 10;
            } else {
                break;
            }
            count++;
        }

        if(a != b) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}