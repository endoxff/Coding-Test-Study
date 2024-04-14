package week01.BOJ_9012_괄호;
import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Stack<Character> stack = new Stack<>();

        sc.nextLine();
        for(int i = 0; i < T; i++) {
            String s = sc.nextLine();
            int flag = 1;
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '(') {
                    stack.push(s.charAt(j));
                }
                if(s.charAt(j) == ')') {
                    if(stack.empty()) {
                        flag = 0;
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty() & flag == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
            stack.clear();
        }
    }
}