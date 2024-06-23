import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 19;
    static int[][] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i][j] != 0) {
                    int count = 1;
                    //가로 확인
                    for (int k = j - 1; k > 0; k--) {
                        if (A[i][j] == A[i][k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    for (int k = j + 1; k <= N; k++) {
                        if (A[i][j] == A[i][k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count == 5) {
                        System.out.println(A[i][j]);
                        System.out.println(i + " " + j);
                        return;
                    }

                    //세로 확인
                    count = 1;
                    for (int k = i - 1; k > 0; k--) {
                        if (A[i][j] == A[k][j]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    for (int k = i + 1; k <= N; k++) {
                        if (A[i][j] == A[k][j]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count == 5) {
                        System.out.println(A[i][j]);
                        System.out.println(i + " " + j);
                        return;
                    }

                    //역대각선 확인
                    count = 1;
                    for (int k = 1; k <= N; k++) {
                        if (i - k > 0 && j - k > 0 && A[i][j] == A[i - k][j - k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    for (int k = 1; k <= N; k++) {
                        if (i + k <= N && j + k <= N && A[i][j] == A[i + k][j + k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (count == 5) {
                        System.out.println(A[i][j]);
                        System.out.println(i + " " + j);
                        return;
                    }

                    //대각선 확인
                    count = 1;
                    int x = i;
                    int y = j;
                    for (int k = 1; k <= N; k++) {
                        if (i - k > 0 && j + k <= N && A[i][j] == A[i - k][j + k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    for (int k = 1; k <= N; k++) {
                        if (i + k <= N && j - k > 0 && A[i][j] == A[i + k][j - k]) {
                            count++;
                        } else {
                            x = i + k - 1;
                            y = j - k + 1;
                            break;
                        }
                    }
                    if (count == 5) {
                        System.out.println(A[i][j]);
                        System.out.println(x + " " + y);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

}