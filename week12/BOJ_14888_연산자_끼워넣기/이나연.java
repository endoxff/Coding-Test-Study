import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    static int[] A, operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        operator = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int value, int index) {
        if (index == N) {
            MAX = Math.max(MAX, value);
            MIN = Math.min(MIN, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch(i) {
                    case 0:
                        dfs(value + A[index], index + 1);
                        break;
                    case 1:
                        dfs(value - A[index], index + 1);
                        break;
                    case 2:
                        dfs(value * A[index], index + 1);
                        break;
                    case 3:
                        dfs(value / A[index], index + 1);
                        break;
                }

                operator[i]++;
            }
        }
    }

}