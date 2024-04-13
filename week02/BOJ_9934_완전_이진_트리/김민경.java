package week02.BOJ_9934_완전_이진_트리;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class 김민경 {

    public static void inorder(int[] inputArr,  ArrayList<Integer>[] outputArr, int start, int end, int level) {   
        if(start > end) 
            return;
        int mid = (start + end) / 2;

        outputArr[level].add(inputArr[mid]);
        inorder(inputArr, outputArr, start, mid - 1, level + 1);
        inorder(inputArr, outputArr, mid + 1, end, level + 1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int level = (int) (Math.pow(2, K) - 1);
        int[] inputArr = new int[level + 1];
        // 8
        ArrayList<Integer>[] outputArr = new ArrayList[K + 1];
        //ArrayList을 담은 배열
        for(int i = 0; i <= K; i++) {
            outputArr[i] = new ArrayList<Integer>();
        }
        //0 1 2 3 4
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int index = 1;
        while(st.hasMoreTokens()) {
            inputArr[index++] = Integer.parseInt(st.nextToken());
        }
        //[]
        //String str = br.readLine();
        //String[] arr =  str.split(" ");
        // for(int i = 1; i <= inputArr.length; i++) {
        //     inputArr[i] = Integer.parseInt(arr[i]);
        // }

        inorder(inputArr, outputArr, 1, inputArr.length - 1, 1);

        for(int i = 1; i <= K; i++) {
            for(int j = 0; j < outputArr[i].size(); j++) {
                System.out.print(outputArr[i].get(j) + " ");
            }
            System.out.println();
        }
    }

}