import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < num; i++) {
            int data = Integer.parseInt(br.readLine());

            if (data != 0) {
                stack.push(data);
                sum += data;
            }
            else {
                int wrong_data = stack.pop();
                sum -= wrong_data;
            }
        }
        System.out.println(sum);
    }
}