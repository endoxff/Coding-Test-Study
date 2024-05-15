import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] coordinate = new int[n];
        int[] sortedArray = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            coordinate[i] = x;
            sortedArray[i] = x;
        }

        Arrays.sort(sortedArray);

        int index = 0;
        for (int value : sortedArray) {
            if (!hashMap.containsKey(value)) {
                hashMap.put(value, index);
                index++;
            }
        }

        for (int value : coordinate) {
            sb.append(hashMap.get(value)).append(" ");
        }

        System.out.println(sb);

    }

}
