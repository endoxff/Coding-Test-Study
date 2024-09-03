import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());
        for (int i = 1; i <= P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int count = 0;
            int[] A = new int[20];
            for (int j = 0; j < 20; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if (A[k] > A[j]) {
                        count++;
                    }
                }
            }

            sb.append(i + " " + count + "\n");
        }

        System.out.println(sb);
    }

}