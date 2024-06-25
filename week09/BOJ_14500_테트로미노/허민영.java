import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //14500 - 테트로미노
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static int n,m;
    static int [][] map;

    static boolean[][] visited;
    static int maxSum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int r = 0; r<n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];


        for(int r = 0; r < n; r++){
            for(int c = 0; c<m;c++){
                visited[r][c] = true;
                //'ㅜ'를 제외한 나머지 경우는 DFS로 탐색해보기
                dfs(r,c,1,map[r][c]);
                //'ㅜ'는 별도로 처리
                maxSum = Math.max(getLast(r,c),maxSum);
                visited[r][c] = false;
            }
        }

        System.out.println(maxSum);

    }

    //'ㅜ'자 처리하는 함수
    private static int getLast(int row, int col) {

        int base = map[row][col];
        int cnt = 0; //사방탐색 성공횟수
        int min = Integer.MAX_VALUE;

        for(int d = 0; d<dirs.length; d++){
            int nr = row+ dirs[d][0];
            int nc = col + dirs[d][1];
            if(isIn(nr,nc)){
                cnt++;
                base += map[nr][nc];
                min = Math.min(min, map[nr][nc]); //가장 작은 수 저장변수
            }
        }

        if(cnt ==4){
            return base - min;
        }
        else if(cnt == 3){
            return base;
        }
        else{
            return -1;
        }

    }

    private static void dfs(int row, int col, int cnt, int sum) {
        if(cnt == 4){
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for(int d = 0; d < dirs.length; d++){
            int nr = row + dirs[d][0];
            int nc = col+ dirs[d][1];

            if(isIn(nr,nc) && !visited[nr][nc]){
                visited[nr][nc] = true;
                dfs(nr,nc,cnt+1, sum+map[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }
    static boolean isIn(int r, int c) { //행열의 index가 유효한지 검증
        if(r < 0 || r >= n || c < 0 || c >= m) return false;
        return true;
    }

}