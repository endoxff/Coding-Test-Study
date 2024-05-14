import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static int solution(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }
        int max = -1;
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(i != arr.length - 1 && arr[i + 1] == arr[i]) {
                count += 1;
                continue;
            }
            if(max == count) {
                list.add(arr[i]);
            } else if(count > max) {
                max = count;
                list.clear();
                list.add(arr[i]);
            }
            count = 1;
        }
        Collections.sort(list);

        if(list.size() == 1) {
            return list.get(0);
        } else {
            return list.get(1);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        double total = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        System.out.println((int)Math.round(total/arr.length));
        Arrays.sort(arr);
        System.out.println(arr[(arr.length/2)]);
        System.out.println(solution(arr));
        System.out.println(arr[arr.length - 1] - arr[0]);
    }
}