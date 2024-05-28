import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int cnt = n / 5;
        boolean flag = false;
        for(int i = cnt; i >= 0; i--) {
            int temp = n - (5 * i);
            count = i;
            if(temp % 3 == 0) {
                count += temp / 3;
                flag = true;
                break;
            }
        }
        if(flag) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}