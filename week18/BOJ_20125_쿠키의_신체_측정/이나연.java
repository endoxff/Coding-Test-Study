import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] cookie = new char[N][N];
        for (int i = 0; i < N; i++) {
            cookie[i] = br.readLine().toCharArray();
        }

        //심장 찾기
        int x = 0;
        int y = 0;
        boolean find = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cookie[i][j] == '*') {
                    x = i + 1;
                    y = j;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }

        //왼팔 길이 구하기
        int leftArm = 0;
        for (int i = y - 1; i >= 0; i--) {
            if (cookie[x][i] != '*') {
                break;
            }
            leftArm++;
        }
        //오른팔 길이 구하기
        int rightArm = 0;
        for (int i = y + 1; i < N; i++) {
            if (cookie[x][i] != '*') {
                break;
            }
            rightArm++;
        }

        //허리 길이 구하기
        int waist = 0;
        for (int i = x + 1; i < N; i++) {
            if (cookie[i][y] != '*') {
                break;
            }
            waist++;
        }

        //왼쪽 다리 길이 구하기
        int tmpX = x + waist + 1;
        int leftLeg = 0;
        for (int i = x + waist + 1; i < N; i++) {
            if (cookie[i][y - 1] != '*') {
                break;
            }
            leftLeg++;
        }
        //오른쪽 다리 길이 구하기
        int rightLeg = 0;
        for (int i = x + waist + 1; i < N; i++) {
            if (cookie[i][y + 1] != '*') {
                break;
            }
            rightLeg++;
        }

        System.out.println((x + 1) + " " + (y + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }

}