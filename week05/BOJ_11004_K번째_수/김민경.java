import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    static void quicksort(int[] arr, int l, int r, int n) {
        int left = l;
        int right = r;
        int pivot = arr[(left + right) / 2];
        while(left <= right) {
            while(arr[left] < pivot) {
                left++;
            }
            while(arr[right] > pivot) {
                right--;
            }
            if(left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        
        if(l < right) {
            quicksort(arr, l, right, n);
        }
        if(left < r) {
            quicksort(arr, left, r, n);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quicksort(arr, 0, arr.length - 1, n);

        System.out.println(arr[k - 1]);
    }
}