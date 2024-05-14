import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //11004번 - k번째 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] B = new int[n];

        String[] input = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
            B[j] = Integer.parseInt(input[j]);
        }

        m_pivot_sort(B, 0, B.length - 1);


        bw.write(String.valueOf(B[k - 1]));
        bw.flush();
        bw.close();
    }

    private static void m_pivot_sort(int[] a, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        m_pivot_sort(a, lo, pivot);
        m_pivot_sort(a, pivot + 1, hi);


    }

    private static int partition(int[] a, int left, int right) {

        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];

        while (true) {

            do {
                lo++;
            } while (a[lo] < pivot);
            do {
                hi--;
            } while (a[hi] > pivot && lo <= hi);

            if (lo >= hi) {
                return hi;
            }
            swap(a, lo, hi);
        }

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}