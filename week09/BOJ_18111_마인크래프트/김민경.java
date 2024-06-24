import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

// 인벤토리에 블록이 있는지 확인
// 평평한 땅을 만들기 위해 필요한 블록의 개수를 확인
// 인벤토리 > 필요한 블록 -> 2번  작업
// 인벤토리 < 필요한 블록 -> 1번 작업
// 1번 작업을 진행하면서 1번 조건을 만족할 수도 있기 때문에 매번 확인 필요!
// 1 2 3 6 필요한 블록은 5, 4, 3개
// 6으로 맞추는 -> 12초
// 3으로 맞추는 -> 3초 + 6초 -> 9초 ---젤 작음
// 2로 맞추는 -> 1초 + 2초 + 8초 -> 10초
// 1로 맞추는 -> 16초

//Hashset에다가 담아
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] ground = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        int height = 0;
        for(int bl = 0; bl <= 256; bl++) {
            int task1 = 0;
            int task2 = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(bl == ground[i][j]) continue;
                    if(bl < ground[i][j]) { // 블록 제거. 작업 1
                        task1 += ground[i][j] - bl;
                    } else {
                        task2 += bl - ground[i][j];
                    }
                }
            }
            if(task1 + b >= task2 && task1 * 2 + task2 <= min) {
                height = Math.max(height, bl);
                min = Math.min(min, task1 * 2 + task2);
            }
        }
        System.out.println(min + " " + height);
    }
}