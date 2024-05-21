import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //1051 - 숫자 정사각형

    static int[][] box;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(input[j]);
            }
        }

        int len = 0;
        int maxsize = 0;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m - 1; k++) {
                int pivot = box[i][k];
                len = 0;
                for (int j = k + 1; j < m; j++) {
                    if (pivot == box[i][j]) {
                        len++;
                        if (len + i < n) {
                            if (pivot == box[i + len][k]) {
                                if (pivot == box[i + len][k + len]) {
                                    int wh = (len + 1) * (len + 1);
                                    if (maxsize < wh) {
                                        maxsize = wh;
                                    }
                                }
                            }
                        }
                    } else {
                        len++;
                    }
                }

            }
        }
        if (maxsize == 0) {
            System.out.println(1);
        } else {
            System.out.println(maxsize);
        }


    }
}