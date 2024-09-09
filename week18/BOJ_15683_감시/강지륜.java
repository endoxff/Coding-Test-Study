import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    
    static int N, M, idx;
    static int min = Integer.MAX_VALUE;
    static int [][] office, temp;
    static int[] selected;
    static ArrayList<Point> wall = new ArrayList<>();
    static Map<Point, Integer> camara = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        office = new int[N][M];

        for(int i=0; i<N; i++) {
            split = br.readLine().split(" ");

            for(int j=0; j<split.length; j++) {
                if (split[j].equals("6"))
                    wall.add(new Point(i, j));
                else if(!split[j].equals("0")) 
                    camara.put(new Point(i, j), Integer.parseInt(split[j]));

                office[i][j] = Integer.parseInt(split[j]);
            }
        }

        selected = new int[camara.size()];

        dfs(0);
        System.out.println(min);
    }

    static void dfs(int cnt) {

        if (cnt == camara.size()) {
            cctv(selected);
            return;
        }

        for(int i=0; i<4; i++) {
            selected[cnt] = i;
            dfs(cnt+1);
        }

    }

    static int[][] copy() {
        int[][] array = new int[N][M];

        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
            array[i][j] = office[i][j];

        return array;
    }

    static void cctv(int[] selectedCamara) {




        idx = 0;
        temp = copy();

        camara.forEach((point, dir) -> {
            
            int x = point.x;
            int y = point.y;

            switch (dir) {
                case 1:
                    if (selectedCamara[idx] == 0) 
                       right(x, y);
                    else if (selectedCamara[idx] == 1) 
                        down(x, y);
                    else if (selectedCamara[idx] == 2) 
                        left(x, y);
                    else
                        up(x, y);
                    
                    break;
                case 2:
                    if (selectedCamara[idx] == 0 || selectedCamara[idx] == 2) {
                        right(x, y);
                        left(x, y);
                    }
                    else {
                        down(x, y);
                        up(x, y);
                    }

                    break;
                case 3:
                    if (selectedCamara[idx] == 0) {
                        up(x, y);
                        right(x, y);
                    } else if (selectedCamara[idx] == 1) {
                         right(x, y);
                         down(x, y);
                    } else if (selectedCamara[idx] == 2) {
                        down(x, y);
                        left(x, y);
                    } else {
                        left(x, y);
                        up(x, y);
                    }

                    break;
                case 4: 
                    if (selectedCamara[idx] == 0) {
                        up(x, y);
                        right(x, y);
                        left(x, y);
                    } else if (selectedCamara[idx] == 1) {
                        right(x, y);
                        up(x, y);
                        down(x, y);
                    } else if (selectedCamara[idx] == 2) {
                        down(x, y);
                        left(x, y);
                        right(x, y);
                    } else {
                        left(x, y);
                        up(x, y);
                        down(x, y);
                    }
                    break;
                case 5:  
                    right(x, y);
                    up(x, y);
                    left(x, y);
                    down(x, y);
                    break;
            }
            idx++;
        });

        int result = 0;
        for(int i = 0; i<N; i++) {
            for(int j=0; j <M; j++) {
                if (temp[i][j] == 0)
                    result++;
            }
        }

        min = Math.min(min, result);
    }


    static void up(int x, int y) {
        for(int i = x-1; i > -1; i--) {
            if (temp[i][y] == 6)
                break;

            if (temp[i][y] == 0)   
                temp[i][y] = 9;
        }
    }

    static void down(int x, int y) {
        for(int i = x+1; i<N; i++) {
            if (temp[i][y] == 6)
                break;

            if (temp[i][y] == 0)
                temp[i][y] = 9;
        }
    }

    static void left(int x, int y) {
        for(int i = y-1; i > -1; i--) {
            if (temp[x][i] == 6)
                break;
            
            if (temp[x][i] == 0)
                temp[x][i] = 9;
        }
    }

    static void right(int x, int y) {
        for(int i = y+1; i<M; i++) {
            if (temp[x][i] == 6)
                break;

            if (temp[x][i] == 0) 
                temp[x][i] = 9;
        }
    }

}
