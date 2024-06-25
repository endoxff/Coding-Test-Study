import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        ArrayDeque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '<'){
                while(str.charAt(i) != '>'){
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.append('>');
            }
            else if(str.charAt(i) == ' '){
                sb.append(" ");
            }
            else{
                while(i < str.length() && str.charAt(i) != ' ' && str.charAt(i) != '<'){
                    deque.addLast(str.charAt(i));
                    i++;
                }

                int size = deque.size();
                for(int j = 0; j < size; j++){
                    sb.append(deque.pollLast());
                }
                i--;
            }
        }

        System.out.println(sb.toString());
    }

}
