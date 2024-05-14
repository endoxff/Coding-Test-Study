import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Integer> num = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(num);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int result = binarySearch(num, Integer.parseInt(st.nextToken()));
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

    static int binarySearch(List<Integer> num, int key) {
        int left = 0;
        int right = num.size() - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (num.get(mid) == key) {
                return 1;
            }

            if (num.get(mid) < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }
}
