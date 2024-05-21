import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.IntBuffer;
import java.util.StringTokenizer;

public class Main {
   //2468 - 안전 영역
    static int map[][];
    static boolean visitied[][];

    static int N;

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j],max);   //가장 높은 높이를 구하기 위해서 최대값을 찾는다.

            }
        }
        int tempMax = 0;
        for (int height = 0; height <= max; height++) {
            //높이가 0부터 가장 높은 높이까지 모든 경우의 수를 보기 위해서 for문을 돌린다.
            visitied = new boolean[N][N]; //방문여부의 배열 초기화
            int count = 0;
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visitied[i][j] && map[i][j] > height ){
                        //방문한적없고, map의 값이 높이보다 큰값이 있다면, 안전영역이라는 의미이므로 dfs함수를 돌려준다.
                        //dfs 호출이 한번 끝나면, count를 하나 증가시킨다.(안전 영역을 센다)
                        count += dfs(i,j,height);
                    }
                }
            }
            tempMax = Math.max(tempMax,count);  //안전영역의 최댓값을 구한다.
        }
        System.out.println(tempMax);
    }

    static int dfs(int x,int y,int height){
        visitied[x][y] = true;

        for (int i = 0; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;
            if(visitied[nx][ny])  //이미 방문했다면 continue
                continue;
            if (map[nx][ny] > height)  //높이보다 높으면 dfs를 한번 더 호출한다.
                dfs(nx,ny,height);
        }
        return 1; //1을 반환한다.(안전영역 1개 추가의 의미)

    }
}