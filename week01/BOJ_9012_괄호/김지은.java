import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String ps = br.readLine();
            Stack<Integer> stk = new Stack<Integer>();
            boolean flag = true;

            for (int j = 0; j < ps.length(); j++) {
                if (ps.charAt(j) == '(') {
                    stk.push(j);
                } else if (ps.charAt(j) == ')') {
                    if (!stk.isEmpty())
                        stk.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stk.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

}
