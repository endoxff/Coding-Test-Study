package week01.BOJ_10773_제로;
import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < K; i++) {
            int k = sc.nextInt();
            if(k != 0)
                stack.push(k);
            else
                stack.pop();
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
