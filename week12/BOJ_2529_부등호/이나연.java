import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static String MIN = "9876543210";
    static String MAX = "0";
    static int[] A;
    static char[] sign;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sign = new char[N];
        for (int i = 0; i < N; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            dfs(i, Integer.toString(i), 0);
        }

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int before, String num, int index) {
        if (index == N) {
            long maxValue = Long.parseLong(MAX);
            long minValue = Long.parseLong(MIN);
            long value = Long.parseLong(num);
            if (value < minValue) {
                MIN = num;
            }
            if (value > maxValue) {
                MAX = num;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if (sign[index] == '<') {
                    if (before < i) {
                        visited[i] = true;
                        dfs(i, num + i, index + 1);
                        visited[i] = false;
                    }
                } else {
                    if (before > i) {
                        visited[i] = true;
                        dfs(i, num + i, index + 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}