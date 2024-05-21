import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] rectangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        rectangle = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                rectangle[i][j] = row.charAt(j);
            }
        }

        int length = Math.min(n, m);
        int size = 1;

        while (length > 1) {
            size = findSquare(length, n, m);
            if (size != 1) {
                break;
            }

            length--;
        }

        System.out.println(size);
    }

    static int findSquare(int len, int n, int m) {
        for (int i = 0; i <= n - len; i++) {
            for (int j = 0; j <= m - len; j++) {
                char c = rectangle[i][j];

                if (c == rectangle[i][j + len - 1] && c == rectangle[i + len - 1][j] && c == rectangle[i + len - 1][j + len - 1]) {
                    return len * len;
                }
            }
        }

        return 1;
    }
}
