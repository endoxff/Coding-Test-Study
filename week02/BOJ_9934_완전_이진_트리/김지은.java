import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        int size = (int)Math.pow(2, k) - 1;
        int[] num = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            tree[i] = new ArrayList<>();
        }

        levelorder(k, num, 0, 0, size - 1);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < tree[i].size(); j++) {
                sb.append(tree[i].get(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void levelorder(int k, int[] num, int depth, int start, int end) {
        if (depth == k)
            return;
        else {
            int mid = (start + end) / 2;
            tree[depth].add(num[mid]);

            levelorder(k, num, depth + 1, start, mid - 1);
            levelorder(k, num, depth + 1, mid + 1, end);
        }

    }
}
