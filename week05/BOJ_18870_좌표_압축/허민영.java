import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] clonearr;

    public static void main(String[] args) throws IOException {
        //arrays.sort 시간초과 -> 퀵정렬로?
        //퀵정렬도 시간초과 -> 뭘 원하는거지
        //실제로 압축을 해야하나
        //hashSet..? -> 중복 허용 X
        //답은 hashMap<Integer,Integer>이었다.
        //풀지 못함


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        clonearr = new int[n];

        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();//압축할 map

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            clonearr[i] = arr[i];
        }

        //랜덤값으로 배열에 입력이 되므로 Arrays.sort가 퀵정렬보다 더 좋은 성능
        Arrays.sort(clonearr);

        int rank = 0; //배열의 압축값을 map에 저장

        for (int value : clonearr) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
                rank++;
            }
        }

        //원본배열은 보존해야하기 때문에

        for (int v : arr) {
            sb.append(rankMap.get(v)).append(" ");
        }
        System.out.println(sb);
    }

}
