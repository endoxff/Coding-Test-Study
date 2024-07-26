import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] A;
    static int[] operator;
    static int N;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int result, int index) {
        if (index == N) {
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(result + A[index], index + 1);
                        break;
                    case 1:
                        dfs(result - A[index], index + 1);
                        break;
                    case 2:
                        dfs(result * A[index], index + 1);
                        break;
                    case 3:
                        dfs(result / A[index], index + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}