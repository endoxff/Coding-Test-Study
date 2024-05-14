import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(!hashMap.containsKey(sortedArr[i])) {
                hashMap.put(sortedArr[i], index);
                index++;
            }
        }
        for(int i=0; i<n; i++)
			sb.append(hashMap.get(arr[i])+" ");
            System.out.print(sb);
    }
}