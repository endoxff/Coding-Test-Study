import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        Stack<Character> stack; 

        for (int i = 0; i < num; i++) {
            stack = new Stack<>();
            String str = br.readLine();

            for(int j=0; j < str.length(); j++) {
                char c = str.charAt(j);
                
                if (c == '(') 
                    stack.push(c);
                else {
                    if(stack.empty()) {
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }
                }
                
            }
            if (stack.empty())
                System.out.println("YES");
            else
                System.out.println("NO");
            }
    }
}