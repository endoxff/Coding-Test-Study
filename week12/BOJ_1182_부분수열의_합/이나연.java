//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static int N, S, count = 0;
//    static int[] A;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int S = Integer.parseInt(st.nextToken());
//        A = new int[N];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            A[i] = Integer.parseInt(st.nextToken());
//        }
//
//        dfs(0, 0);
//
//        if (S == 0) { //공집합인 경우 제외
//            count--;
//        }
//        System.out.println(count);
//    }
//
//    private static void dfs(int index, int sum) {
//        if (index == N) {
//            if (sum == S) {
//                count++;
//            }
//            return;
//        }
//
//        dfs(index + 1, sum + A[index]);
//        dfs(index + 1, sum);
//    }
//
//}