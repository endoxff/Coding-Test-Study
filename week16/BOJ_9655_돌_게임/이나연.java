import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if ((N / 3 + N % 3) % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

}