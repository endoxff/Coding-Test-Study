import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] nums = { 1, 2, 3 };
    static int[] pick;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int totalCount = 0; // number of case

            for (int j = 1; j <= n; j++) {
                pick = new int[j];
                count = 0;
                permutation(n, j, 0);
                totalCount += count;
            }

            sb.append(totalCount).append("\n");
        }

        System.out.println(sb);
    }

    public static void permutation(int n, int totalPick, int currentPick) {
        if (currentPick == totalPick) { // end condition
            int sum = 0;
            for (int i = 0; i < currentPick; i++) {
                sum += pick[i];
            }

            if (sum == n) {
                count++;
                return;
            } else {
                return;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            pick[currentPick] = nums[i];

            permutation(n, totalPick, currentPick + 1);
        }
    }

}
