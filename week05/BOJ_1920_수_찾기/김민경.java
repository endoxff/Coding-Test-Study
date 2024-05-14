import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;

    }
 
    public static int binary_search(int[] arr, int start, int end, int n) {
        int mid = (start + end) / 2;
        if(arr[mid] == n) {
            return 1;
        }
        if(start < end) {
            if(n < arr[mid]) {
                return binary_search(arr, start, mid - 1, n);
            }
            else {
                return binary_search(arr, mid + 1, end, n);
            }
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            System.out.println(binary_search(arr, 0, arr.length -1, Integer.parseInt(st.nextToken())));
        }
    }
}