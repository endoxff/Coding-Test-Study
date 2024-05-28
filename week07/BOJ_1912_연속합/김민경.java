import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int max = arr[left];
        int temp = 0;
        for(int i = 0; i < n; i++) {
            temp = 0;
            for(int j = left; j <= i; j++) {
                temp += arr[j];
            }
            max = max < arr[i] ? arr[i] : max;
            left = temp <= arr[i] ? i : left;
            right = max < temp ? i : right; 
            max = max < temp ? temp : max;
        }
        System.out.println(max);
    }
}
