import java.util.*;

class Solution {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 상 우 하 좌
    static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        
        visited = new boolean[m][n];
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        
        int cnt = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (!visited[i][j]  && picture[i][j] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, m, n, 0, picture[i][j], picture));
                    numberOfArea++;
                }
                
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int bfs(int x, int y, int m, int n, int sum, int data,  int[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y]= true;
        sum++;
        
        while(!queue.isEmpty()) {
            
            int[] pos = queue.poll();
            
            for(int i=0; i<dir.length; i++) {
                
                int dx = pos[0] + dir[i][0];
                int dy = pos[1] + dir[i][1];
                
                if (dx > -1 && dy > -1 && dx < m && dy < n && !visited[dx][dy] && data == picture[dx][dy]) {
                    visited[dx][dy] = true;
                    queue.offer(new int[] {dx, dy});
                    sum++;
                }
            }
        }
        return sum;
    }
}