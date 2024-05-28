import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int basket = 0;

        while (n > 0) {
            if (n < 3) {
                basket = -1;
                break;
            }
            if (n % 5 == 0) {
                basket += n / 5;
                break;
            }
            n -= 3;
            basket++;
        }

        System.out.println(basket);
    }

}
