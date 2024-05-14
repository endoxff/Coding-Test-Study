import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1920번 - 수 찾기
//시간 제한 1초
//메모리 제한 128MB
//퀵소트로 정렬 + 이분 탐색으로 찾기? 시간 복잡도 -> O(nlogn) + O(logn)
//최악의 시간 복잡도를 막기 위해 중앙 피봇으로 구현
public class Main {
    //60%에서 틀렸다고 함
    // -> 반례 : m에서 하나만 주어졌을 때 " "가 없어서 에러남 (읭? 뭐지 했음 그럼 어케하란말임..?)
    // -> 반례가 중요한게 아님 m까지 돌려야하는데 n까지 돌려버려서 에러났던 거임

    static int[] arr; // 입력 배열
    static int[] findnum; // arr에서 찾아야 하는 수 배열

    public static void main(String[] args) throws IOException {
        //여기부터
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        findnum = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            findnum[i] = Integer.parseInt(st.nextToken());
        }
        //여기까지 배열 입력받는 코드

        quick_sort(arr, 0, arr.length - 1); //퀵소트로 arr 정렬(오름차순)


        for (int j = 0; j < m; j++) {
            int a = binarySearch(findnum[j], 0, arr.length - 1);
            sb.append(a).append("\n");
        }

        System.out.print(sb);
    }

    private static int binarySearch(int key, int low, int high) {
        //이분 탐색
        int mid;
        if (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) {
                return 1;
            } else if (key < arr[mid]) {
                return binarySearch(key, 0, mid - 1);
            } else {
                return binarySearch(key, mid + 1, high);
            }
        }
        return 0;
    }


    private static void quick_sort(int[] arr, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int pivot = partition(arr, lo, hi);
        quick_sort(arr, lo, pivot);
        quick_sort(arr, pivot + 1, hi);

    }

    private static int partition(int[] arr, int left, int right) {

        int lo = left - 1;
        int hi = right + 1;
        int pivot = arr[(lo + hi) / 2];

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

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}