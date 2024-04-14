package week01.BOJ_1158_요세푸스_문제;

import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //10
        int K = sc.nextInt(); //3

        List<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= N; i++)
            arr.add(i);

        StringBuilder result = new StringBuilder();
        result.append("<");
       
        //index + -> 기존 index에서 K번째이기 때문!
        //% arr.size(); -> arr.size()보다 index가 클 경우 대비
        int index = 0;
        while(!arr.isEmpty()) {
            index = (index + K - 1) % arr.size();
            result.append(arr.remove(index));
            if(arr.size() != 0)
                result.append(", ");
        }
        result.append(">");
        System.out.println(result);
    }
}
