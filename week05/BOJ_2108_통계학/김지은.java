import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> num = new ArrayList<>();
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        List<Integer> modes = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(br.readLine()));
            sum += num.get(i);
            hashmap.put(num.get(i), hashmap.getOrDefault(num.get(i), 0) + 1);
        }

        Collections.sort(num);

        int count = 0;
        for (int key : hashmap.values()) {
            count = Math.max(count, key);
        }

        for (int key: hashmap.keySet()) {
            if (hashmap.get(key) == count) {
                modes.add(key);
            }
        }

        Collections.sort(modes);
        int mode = 0;

        if (modes.size() >= 2) {
            mode = modes.get(1);
        } else {
            mode = modes.get(0);
        }

        sb.append((int)Math.round((double)sum / n)).append("\n");
        sb.append(num.get(n / 2)).append("\n");
        sb.append(mode).append("\n");
        sb.append(num.get(n - 1) - num.get(0));

        System.out.println(sb);
    }

}
