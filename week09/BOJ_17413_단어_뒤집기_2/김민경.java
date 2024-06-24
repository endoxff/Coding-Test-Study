import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            if(word == '<') {
                temp.reverse();
                sb.append(temp);
                temp = new StringBuilder();
                flag = true;
            }

            if(flag) {
                temp.append(word);
                if(word == '>') {
                    sb.append(temp);
                    temp = new StringBuilder();
                    flag = false;
                    continue;
                }
            } else {
                if(s.charAt(i) == ' ') {
                    temp.reverse();
                    sb.append(temp).append(" ");
                    temp = new StringBuilder();
                    continue;
                }
                temp.append(word);
            }
        }
        temp.reverse();
        sb.append(temp);
        System.out.println(sb);
    }
}