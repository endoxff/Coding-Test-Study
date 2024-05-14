import java.io.*;

public class Main {
    //퀵정렬을 사용했지만, 랜덤 데이터일 경우에는 Arrays.sort가 퀵정렬보다 성능이 좋다고함.
    //퀵정렬로도 풀리긴 하지만 코드의 수로 봐서는 Arrays.sort로도 한번 풀어보고 돌려보는게 빠르게 풀 수 있는방법인듯
    //나는 최빈값때문에 못풀었음 boolean 값을 생각하지 못함
    static int[] arr;
    static int sum;

    static int cnt;
    static int max;
    static int fre;


    public static void main(String[] args) throws IOException {
        //        2108 - 통계학
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        m_pivot_sort(arr, 0, arr.length - 1);


        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {

            }
        }

        max = -1;
        fre = arr[0];

        boolean check = false;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                cnt++; //앞에서 부터 값이 달라질 때까지 비교를 해서 cnt를 증가시킨다.
            } else {
                cnt = 0;
            }

            if (max < cnt) {
                max = cnt;
                fre = arr[i];
                check = true; //첫번째 작은 수
            } else if (max == cnt && check) {
                fre = arr[i];
                check = false; //두번째 작은 수
            }
        }

        int r = arr[n - 1] - arr[0];

        System.out.println((int) Math.round((double) sum / n)); // 평균값
        System.out.println(arr[(n - 1) / 2]); //중앙값
        System.out.println(fre); //최빈값
        System.out.println(r); //  범위

    }

    private static void m_pivot_sort(int[] arr, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int pivot = partition(arr, lo, hi);
        m_pivot_sort(arr, lo, pivot);
        m_pivot_sort(arr, pivot + 1, hi);
    }

    private static int partition(int[] arr, int left, int right) {

        int lo = left - 1;
        int hi = right + 1;
        int pivot = arr[(left + right) / 2];

        while (true) {
            do {
                lo++;
            } while (arr[lo] < pivot);

            do {
                hi--;
            } while (arr[hi] > pivot && lo <= hi);

            if (lo >= hi) {
                return hi;
            }

            swap(arr, lo, hi);

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}