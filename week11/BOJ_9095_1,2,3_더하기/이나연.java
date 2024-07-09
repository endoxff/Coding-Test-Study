import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N = 11;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] D = new int[N];
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        for (int i = 4; i < N; i++) {
            D[i] = D[i - 1] + D[i - 2] + D[i - 3];
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int find = Integer.parseInt(br.readLine());
            sb.append(D[find]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
